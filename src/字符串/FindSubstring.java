package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-24 21:34
 * motto : everything is no in vain
 * description leetcode 30: 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 */
public class FindSubstring {
    public List<Integer> solution(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        findSubStringHelp(s, words, 0, words.length, resultList);
        return resultList;
    }

    /**
     * 获取所有单词的排列情况，然后判断原字符串是否存在，但是这么做有不好的点就是还得用滑动窗口判断字符串位置，不能直接调用String.indexOf来解决
     * @param s
     * @param words
     * @param start
     * @param length
     * @param resultList
     */
    private void findSubStringHelp(String s, String[] words, int start, int length, List<Integer> resultList) {
        if (start == length - 1) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(word);
            }
            int index = s.indexOf(sb.toString());
            if (index != -1 && resultList.contains(index)) {
                //如果有多处符合那该怎么办？？？
                resultList.add(index);
            }
            return;
        }
        for (int i = start; i < length; i++) {
            swap(words, start, i);
            findSubStringHelp(s, words, start + 1, length, resultList);
            swap(words, start, i);
        }
    }

    private void swap(String[] words, int i, int j) {
        String s = words[i];
        words[i] = words[j];
        words[j] = s;
    }

    public static void main(String[] args) {
//        String[] words = new String[]{"bar", "foo", "the"};
//        for (int i : new FindSubstring().solution("barfoofoobarthefoobarman", words)) {
//            System.out.print(i + " ");
//        }
    }
}
