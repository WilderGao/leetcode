package 笔试题;

/**
 * @author WilderGao
 * time 2019-10-17 16:10
 * motto : everything is no in vain
 * description
 */
public class PinDuoDuoOne {
    private static int TIMES = 0;

    public static void main(String[] args) {
        TIMES = 0;
        boolean result = getMinTimes(1, 3);
        if (result) {
            System.out.println(TIMES);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean getMinTimes(int a, int b) {
        if (a > b) {
            TIMES--;
            return false;
        }
        if (a == b) {
            return true;
        }
        boolean result;
        TIMES++;
        result = getMinTimes(a * 10 + 1, b);
        if (!result) {
            result = getMinTimes(a * 2, b);
        }
        return result;
    }
}
