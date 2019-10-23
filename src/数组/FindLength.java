package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WilderGao
 * time 2019-10-18 21:41
 * motto : everything is no in vain
 * description leetcode 718 : 最长子数组
 */
public class FindLength {
    public int solution(int[] A, int[] B) {
        int lena = A.length;
        int lenb = B.length;
        int res = 0;

        int[][] dp = new int[lena + 1][lenb + 1];

        for (int i = 1; i <= lena; i++) {
            for (int j = 1; j <= lenb; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (res < dp[i][j]) {
                    res = dp[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 2, 1};
        int[] B = new int[]{3, 2, 1, 4, 7};
        System.out.println(new FindLength().solution(A, B));
    }
}
