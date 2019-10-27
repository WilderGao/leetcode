package 数字;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-27 15:43
 * motto : everything is no in vain
 * description leetcode 43: 字符串相乘
 */
public class Multiply {
    public String solution(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int num1Length = num1.length();
        int num2Length = num2.length();
        List<StringBuilder> everyPointResultList;
        if (num1Length < num2Length) {
            everyPointResultList = getEveryPointList(num2, num1, num1Length);
        } else {
            everyPointResultList = getEveryPointList(num1, num2, num2Length);
        }
        StringBuilder resBuilder = new StringBuilder("0");
        for (StringBuilder sb : everyPointResultList) {
            resBuilder = stringPlus(resBuilder, sb);
        }
        return resBuilder.toString();
    }

    private StringBuilder singleMultipy(String num1, char index) {
        int plus = 0;
        StringBuilder result = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int bMul = num1.charAt(i) - 48;
            int mul = index - 48;
            result.append((bMul * mul + plus) % 10);
            plus = (bMul * mul + plus) / 10;
        }
        if (plus != 0) {
            result.append(plus);
        }
        return result.reverse();
    }

    private List<StringBuilder> getEveryPointList(String num1, String changeNum, int length) {
        List<StringBuilder> everyPointResultList = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            StringBuilder singleIndexB = singleMultipy(num1, changeNum.charAt(i));
            for (int j = 0; j < length - 1 - i; j++) {
                singleIndexB.append('0');
            }
            everyPointResultList.add(singleIndexB);
        }
        return everyPointResultList;
    }

    private StringBuilder stringPlus(StringBuilder s1, StringBuilder s2) {
        StringBuilder s1Reverse = s1.reverse();
        StringBuilder s2Reverse = s2.reverse();

        int maxLength = Math.max(s1Reverse.length(), s2Reverse.length());
        StringBuilder result = new StringBuilder();
        int plus = 0;
        for (int i = 0; i < maxLength; i++) {
            int one = i >= s1.length() ? 0 : s1Reverse.charAt(i) - 48;
            int two = i >= s2.length() ? 0 : s2Reverse.charAt(i) - 48;
            result.append((one + two + plus) % 10);
            plus = (one + two + plus) / 10;
        }
        if (plus != 0) {
            result.append(plus);
        }
        return result.reverse();
    }

    public static void main(String[] args) {
        System.out.println(new Multiply().solution("2", "3"));
    }
}
