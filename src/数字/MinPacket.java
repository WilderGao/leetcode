package 数字;

/**
 * @author WilderGao
 * time 2019-10-04 14:58
 * motto : everything is no in vain
 * description 6个或者8个苹果一袋，给定n个苹果，看一共需要买多少袋，如果不能买整，就返回-1
 */
public class MinPacket {

    public static int solution(int num) {
        if (num % 2 != 0 || num < 6) return -1;
        int eightTime = num / 8;
        int eightLeft = num % 8;
        if (eightLeft == 0) {
            //刚好8的能装满，就是最少的了
            return eightTime;
        }
        while (eightTime >= 0) {
            eightTime--;
            int sixLeft = num - eightTime * 8;
            if (sixLeft % 6 == 0) {
                int sixTime = sixLeft / 6;
                return sixTime + eightTime;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(20));
    }
}
