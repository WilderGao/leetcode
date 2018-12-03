/**
 * @author wilder
 * @date 18-11-22 下午2:27
 * motto
 */
public class Increment {
    private int i;
    public void increase(){i++;}
    public int getI(){return i;}

    public static void test(int threadNum, int loopTimes){
        Increment increment = new Increment();
        Thread[] threads = new Thread[threadNum];

        for (int i = 0; i < threads.length; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < loopTimes; j++) {
                        increment.increase();
                    }
                }
            });
            threads[i] = t;
            t.start();
        }

        //主线程等待其他线程运行完毕
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(threadNum+"个县城循环"+loopTimes+"次，结果为："+increment.getI());
    }

    public static void main(String[] args) {
        test(20,10000);
        test(30,100);
        test(20,10);
    }
}
