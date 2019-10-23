package 字符串;

/**
 * @author WilderGao
 * time 2019-10-20 21:28
 * motto : everything is no in vain
 * description leetcode : 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的
 */
public class IsInterleave {
    public boolean solution(String s1, String s2, String s3) {
        if (s1 == null && s2 == null && s3 == null) {
            return true;
        }
        if (s1 == null && s2 != null && s2.equals(s3) || s2 == null && s1 != null && s1.equals(s3)) {
            return true;
        }
        return isInterLeaveHelp(s1, 0, s2, 0, s3, 0);
    }

    private boolean isInterLeaveHelp(String s1, int index1, String s2, int index2, String s3, int index3) {
        if (index1 == s1.length() && index2 == s2.length() && index3 == s3.length()) {
            return true;
        }
        if (index3 >= s3.length()) {
            return false;
        }
        boolean result = false;
        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            result = isInterLeaveHelp(s1, index1 + 1, s2, index2, s3, index3 + 1);
        }
        if (index2 < s2.length() && !result && s2.charAt(index2) == s3.charAt(index3)) {
            result = isInterLeaveHelp(s1, index1, s2, index2 + 1, s3, index3 + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new IsInterleave().solution("aabcc", "dbbca", "aadbbcbcac"));
    }
}
