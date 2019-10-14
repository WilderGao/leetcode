package 字符串;

import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-10-11 16:50
 * motto : everything is no in vain
 * description
 */
public class DecodeString {
    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ']') {
                StringBuilder tmpBuilder = new StringBuilder();
                while (stack.peek() != '[') {
                    tmpBuilder.append(stack.pop());
                }
                stack.pop();
                StringBuilder timeBuilder = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    timeBuilder.append(stack.pop());
                }
                int times = Integer.parseInt(timeBuilder.reverse().toString());
                String indexS = tmpBuilder.toString();
                for (int j = 1; j < times; j++) {
                    tmpBuilder.append(indexS);
                }
                tmpBuilder.reverse();
                for (int j = 0; j < tmpBuilder.length(); j++) {
                    stack.push(tmpBuilder.charAt(j));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            resultBuilder.append(stack.pop());
        }
        return resultBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("100[leetcode]"));
    }
}
