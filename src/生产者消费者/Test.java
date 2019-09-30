package 生产者消费者;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-09-28 15:58
 * motto : everything is no in vain
 * description 生产者
 */
public class Test {
    private static int len = 3;
    private static List<String> list = new ArrayList<>();

    class Pruducer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    while (list.size() == len) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(System.currentTimeMillis() + " ");
                    list.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    if (list.size() == 0) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("消费者消费：" + list.remove(0));
                    list.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Thread consumer = new Thread(test.new Consumer());
        Thread producer = new Thread(test.new Pruducer());
        consumer.start();
        producer.start();
    }
}
