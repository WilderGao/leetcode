/**
 * @author wilder
 * @date 18-11-23 上午11:03
 * motto
 */
public class ThreadLocalDemo {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
           String s = "wilder";
           threadLocal.set(s);
           String sGet = threadLocal.get();
            System.out.println(sGet);
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            String s = "purple";
            threadLocal.set(s);
            String sGet = threadLocal.get();
            System.out.println(sGet);
        });
        thread2.start();
    }
}
