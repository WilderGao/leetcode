package 数字;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WilderGao
 * time 2018-10-23 11:29
 * motto : everything is no in vain
 * description 罗马字符转化成整数
 */
public class RomanToInt {
    public int solution(String s) {
        Map<Character, Integer> romanMap = new HashMap<>(16);
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = romanMap.get(s.charAt(i));
            if (i == s.length() - 1 || romanMap.get(s.charAt(i + 1)) <= romanMap.get(s.charAt(i))) {
                result += val;
            } else {
                result -= val;
            }
        }
        return result;
    }
}
