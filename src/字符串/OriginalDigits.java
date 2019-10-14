package 字符串;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-11 20:22
 * motto : everything is no in vain
 * description leetcode 423:从英文中重建数字
 */
public class OriginalDigits {

    public String solution(String s) {
        List<Integer> result = new ArrayList<>();
        String[] words = new String[]{"zero", "two", "four", "six", "eight", "one", "three", "five", "seven", "nine"};
        int[] counts = new int[26];
        int[] nums = new int[]{0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        char[] chars = new char[]{'z', 'w', 'u', 'x', 'g', 'o', 'h', 'f', 's', 'i'};
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 10; i++) {
            int cnt = counts[chars[i] - 'a'];
            for (int j = 0; j < words[i].length(); j++) {
                counts[words[i].charAt(j) - 'a'] -= cnt;
            }
            while (cnt-- > 0) {
                result.add(nums[i]);
            }
        }
        Collections.sort(result);
        StringBuilder rBuilder = new StringBuilder();
        for (Integer i : result) {
            rBuilder.append(i);
        }
        return rBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new OriginalDigits().solution("fviefuro"));
    }
}
