package 数字;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author WilderGao
 * time 2019-10-27 15:18
 * motto : everything is no in vain
 * description leetcode 38：报数
 */
public class CountAndSay {
    public String solution(int n) {
        int index = 1;
        StringBuilder sb = new StringBuilder("1");
        Map<Character, Integer> map = new LinkedHashMap<>();
        while (index++ < n) {
            map.put(sb.charAt(0), 1);
            StringBuilder sbReplace = new StringBuilder();
            for (int i = 1; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (map.containsKey(c)) {
                    int num = map.get(c);
                    map.put(c, ++num);
                } else {
                    int inputNumBeforeChar = map.get(sb.charAt(i - 1));
                    sbReplace.append(inputNumBeforeChar);
                    sbReplace.append(sb.charAt(i - 1));
                    map.remove(sb.charAt(i - 1));
                    map.put(c, 1);
                }
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                sbReplace.append(entry.getValue());
                sbReplace.append(entry.getKey());
                map.remove(entry.getKey());
            }
            sb = sbReplace;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().solution(6));
        System.out.println(new CountAndSay().solution(7));
        System.out.println(new CountAndSay().solution(8));
    }
}
