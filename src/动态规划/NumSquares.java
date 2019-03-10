package 动态规划;

/**
 * @author WilderGao
 * time 2019-03-05 15:43
 * motto : everything is no in vain
 * description leetcode 279
 */
public class NumSquares {
    private int solution(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            result[i] = i;
        }
        for (int i = 1; i <= num; i++) {
            int j = 1;
            while (j * j <= i) {
                result[i] = Math.min(result[i], result[i - j * j] + 1);
                j++;
            }
        }
        return result[num];
    }
}
