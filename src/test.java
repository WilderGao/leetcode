import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @author WilderGao
 * time 2019-03-23 17:20
 * motto : everything is no in vain
 * description
 */
public class test {
    static class A{
        public void sb(){
            System.out.println("a 调用 sb");
        }
    }
    static class B extends A{
        @Override
        public void sb() {
            System.out.println("b 调用 sb");
        }
    }
    static class C extends B{
        @Override
        public void sb() {
            System.out.println("c 调用 sb");
        }
    }


    public void a(A a){
        System.out.println("a method");
    }

    public void a(B a){
        System.out.println("b method");
    }

    public void a(C c){
        System.out.println("c method");
    }

    public static void main(String[] args) {
        test test = new test();
        A a = new A();
        A b = new B();
        A c = new C();

        test.a(a);
        test.a(b);
        test.a(c);

        a.sb();
        b.sb();
        c.sb();
    }
}
