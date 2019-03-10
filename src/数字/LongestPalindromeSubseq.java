package 数字;

/**
 * @author wilder
 * @date 19-3-10 下午9:54
 * description leetcode 516 最长回文子序列（不是连续子序列）
 */
public class LongestPalindromeSubseq {
    private int solution(String s){
        if (s == null) return 0;
        int[][] result = new int[s.length()][s.length()];
        result[0][0] = 1;
        for (int i = 1; i < result.length; i++) {
            //表示第i位字符串到第i位字符串的回文长度为1
            result[i][i] = 1;
            for (int j = i-1; j>=0 ; j--) {
                if (s.charAt(i) == s.charAt(j)){
                    result[i][j] = result[i-1][j+1] + 2;
                }else {
                    result[i][j] = Math.max(result[i][j+1], result[i-1][j]);
                }
            }
        }
        return result[s.length()-1][0];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubseq().solution("bbbab"));
    }
}
