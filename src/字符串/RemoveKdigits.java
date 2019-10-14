package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-11 19:42
 * motto : everything is no in vain
 * description
 */
public class RemoveKdigits {
    public static String solution(String num, int k) {
        if (num == null || num.length() <= k) return "0";
        int length = num.length();
        if (k == 0) return num;
        int removeTimes = 0;
        StringBuilder numBuilder = new StringBuilder(num);
        int i = 0, j = 1;
        while (j < length && removeTimes < k) {
            if (i >= 0 && numBuilder.charAt(i) > numBuilder.charAt(j)) {
                numBuilder.deleteCharAt(i);
                i--;
                j--;
                length--;
                removeTimes++;
            } else {
                i++;
                j++;
            }
        }
        while (removeTimes < k) {
            numBuilder.deleteCharAt(numBuilder.length() - 1);
            removeTimes++;
        }
        while (numBuilder.length() > 0 && numBuilder.charAt(0) == '0') {
            numBuilder.deleteCharAt(0);
        }
        return numBuilder.toString().equals("") ? "0" : numBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("4321", 2));
    }
}
