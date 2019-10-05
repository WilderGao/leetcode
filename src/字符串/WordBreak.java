package 字符串;

import java.util.Arrays;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-04 10:36
 * motto : everything is no in vain
 * description leetcode 139:单词拆分
 */
public class WordBreak {
    public static boolean solution(String s, List<String> wordDict) {
        int length = s.length();
        int[] memo = new int[length];
        for (int i = 0; i < length; i++) {
            memo[i] = -1;
        }
        return wordBreakHelp(s, wordDict, 0, memo);
    }

    private static boolean wordBreakHelp(String s, List<String> wordDict, int start, int[] memo) {
        if (start >= s.length()){
            return true;
        }
        if (memo[start] != -1){
            return memo[start] == 1;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i)) && wordBreakHelp(s, wordDict, i, memo)) {
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = 0;
        return false;
    }

    public static void main(String[] args) {
        String[] ss = new String[]{"leet", "code"};
        String s = "leetcode";
        System.out.println(solution(s, Arrays.asList(ss)));

        String[] ss2 = new String[]{"cats", "dog", "sand", "and", "cat"};
        System.out.println(solution("catsandog", Arrays.asList(ss2)));
    }
}
