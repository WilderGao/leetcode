package 数字;

import java.util.HashSet;
import java.util.Set;

/**
 * @author WilderGao
 * time 2019-10-06 11:39
 * motto : everything is no in vain
 * description leetcode 202:快乐数
 */
public class IsHappy {
    public static boolean solution(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            if (set.contains(n)) break;
            set.add(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(19));
        System.out.println(solution(11));
    }
}
