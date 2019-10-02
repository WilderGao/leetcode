package 动态规划;

/**
 * @author WilderGao
 * time 2019-10-02 15:08
 * motto : everything is no in vain
 * description leetcode 5:最长回文字串
 */
public class LongestPalindrome {
    public static String solution(String s) {
        if (s == null || s.length() < 2) return s;
        //利用动态规划来解决问题
        int length = s.length();
        int left = 0;
        int[][] dp = new int[length][length];
        int maxLen = 1;
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            for (int j = 0; j <= i; j++) {
                //当前两个指针指向的值相等[i - j < 2是判断他们有没有相邻]
                if ((s.charAt(i) == s.charAt(j)) && (i - j < 2 || dp[i - 1][j + 1] == 1)) {
                    dp[i][j] = 1;
                }
                if (dp[i][j] == 1 && maxLen < i - j + 1) {
                    maxLen = i - j + 1;
                    left = j;
                }
            }
        }
        return s.substring(left, left + maxLen);
    }

    public static void main(String[] args) {
        String a = "abcdbbfcba";
        System.out.println(solution(a));
    }
}
