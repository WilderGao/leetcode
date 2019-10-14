package 字符串;

/**
 * @author WilderGao
 * time 2019-10-14 15:18
 * motto : everything is no in vain
 * description leetcode 72 : 最短距离（动态规划是真的牛逼）
 */
public class MinDistance {
    public static int solution(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= length2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = dp[i - 1][j - 1];
                    int add = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    dp[i][j] = Math.min(Math.min(replace, add), delete) + 1;
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        System.out.println(solution("intention", "execution"));
    }
}
