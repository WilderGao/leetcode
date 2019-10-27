package 数字;

/**
 * @author WilderGao
 * time 2019-10-23 20:13
 * motto : everything is no in vain
 * description leetcode 552: 学生出勤记录Ⅱ
 */
public class CheckRecord {

    private static int pow = (int) Math.pow(10, 9) + 7;

    /**
     * 用递归解决问题，没有办法OC
     * @param n
     * @return
     */
    public int solution(int n) {
        int[] f = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = func(i);
        }
        int sum = f[n];
        for (int i = 1; i <= n; i++) {
            sum += (func(i - 1) * func(n - i)) % pow;
        }
        return sum;
    }

    private int func(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 4;
        }
        if (n == 3) {
            return 7;
        }
        return (2 * func(n - 1) - func(n - 4)) % pow;
    }

    public static void main(String[] args) {
        System.out.println(new CheckRecord().solution(3));
    }
}
