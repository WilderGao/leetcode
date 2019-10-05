package 数组;

import java.util.*;

/**
 * @author WilderGao
 * time 2019-10-05 16:31
 * motto : everything is no in vain
 * description leetcode 839：相似字符串组
 */
public class NumSimilarGroups {
    public static int solution(String[] ss) {
        int times = 0;
        Set<String> storeSet = new HashSet<>();
        for (String s : ss) {
            if (storeSet.contains(s)) {
                continue;
            }
            times++;
            numSimilarGroupHelp(ss, storeSet, s);
        }
        return times;
    }

    /**
     * 使用DFS解决问题
     */
    private static void numSimilarGroupHelp(String[] ss, Set<String> storeSet, String currentWord) {
        if (storeSet.contains(currentWord)) {
            return;
        }
        storeSet.add(currentWord);
        for (String s : ss) {
            if (isSimilar(s, currentWord)) {
                numSimilarGroupHelp(ss, storeSet, s);
            }
        }
    }

    private static boolean isSimilar(String a, String b) {
        int times = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                continue;
            }
            if (++times > 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"tars", "rats", "arts", "star"};
        System.out.println(solution(a));
    }
}
