package 数组;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author WilderGao
 * time 2019-10-02 10:23
 * motto : everything is no in vain
 * description leetcode 1170
 */
public class NumSmallerByFrequency {
    public static int[] solution(String[] requires, String[] words) {
        int[] result = new int[requires.length];
        for (int i = 0; i < requires.length; i++) {
            int requireNum = getFirstWordNum(requires[i]);
            int times = 0;
            for (String word : words) {
                int wordNum = getFirstWordNum(word);
                if (requireNum < wordNum) {
                    times++;
                }
            }
            result[i] = times;
        }
        return result;
    }

    private static int getFirstWordNum(String require) {
        if (require == null || require.length() == 0) return 0;
        char[] requireChars = require.toCharArray();
        Arrays.sort(requireChars);
        int num = 0;
        for (int i = 0; i < requireChars.length - 1; i++) {
            if (requireChars[i] == requireChars[i + 1]) {
                num++;
            } else {
                break;
            }
        }
        return num + 1;
    }

    public static int[] solutionUpdate(String[] queries, String[] words) {
        //分别计算出两个数组的最小字符出现次数
        List<String> queriesList = Arrays.asList(queries);
        List<Integer> queriesResult = queriesList.stream().map(NumSmallerByFrequency::getFirstWordNum).collect(Collectors.toList());

        //words的最小字符次数计算并按照降序排列
        List<String> wordsList = Arrays.asList(words);
        List<Integer> wordResult = wordsList.stream().map(NumSmallerByFrequency::getFirstWordNum)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());


        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int first = 0, end = wordResult.size();
            while (first <= end) {
                int mid = (first + end) / 2;
                if (mid != first && mid != end) {
                    if (queriesResult.get(i) >= wordResult.get(mid)) {
                        end = mid;
                    } else {
                        first = mid;
                    }
                } else if (mid == 0 && queriesResult.get(i) >= wordResult.get(mid)) {
                    result[i] = 0;
                    break;
                } else {
                    result[i] = mid + 1;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] requires = new String[]{"bbb", "cc"};
        String[] words = new String[]{"a", "aa", "aaa", "aaaa"};

        for (int i : solutionUpdate(requires, words)) {
            System.out.println(i);
        }
    }
}
