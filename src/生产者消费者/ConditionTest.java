package 生产者消费者;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WilderGao
 * time 2019-09-28 16:40
 * motto : everything is no in vain
 * description
 */
public class ConditionTest {
    private Lock lock = new ReentrantLock(true);
    private static int len = 3;
    private Condition producerCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();
    List<String> list = new ArrayList<>();

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                if (list.size() == len) {
                    try {
                        producerCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add("" + System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName() + "生产者生产");
                consumerCondition.signal();
                lock.unlock();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                while (list.size() == 0) {
                    try {
                        consumerCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String a = list.get(0);
                System.out.println(Thread.currentThread().getName() + "消费者消费："+ a);
                list.remove(0);
                producerCondition.signal();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ConditionTest test = new ConditionTest();
        Thread producer = new Thread(test.new Producer());
        Thread consumer = new Thread(test.new Consumer());
        Thread producer2 = new Thread(test.new Producer());
        Thread consumer2 = new Thread(test.new Consumer());
        Thread producer3 = new Thread(test.new Producer());
        Thread consumer3 = new Thread(test.new Consumer());
        producer.start();
        consumer.start();
        producer2.start();
        consumer2.start();
        producer3.start();
        consumer3.start();
    }
}
