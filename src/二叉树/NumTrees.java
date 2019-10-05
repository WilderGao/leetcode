package 二叉树;

/**
 * @author WilderGao
 * time 2019-10-03 15:21
 * motto : everything is no in vain
 * description leetcode 96： 不同的二叉搜索树
 */
public class NumTrees {
    public static int solution(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
