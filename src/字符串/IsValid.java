package 字符串;

import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-10-04 22:10
 * motto : everything is no in vain
 * description leetcode 20:有效的括号 （个人觉得可以用栈来解决）
 */
public class IsValid {
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            } else if (!stack.isEmpty() && c == '}' && '{' == stack.pop()) {
                continue;
            } else if (!stack.isEmpty() && c == ']' && '[' == stack.pop()) {
                continue;
            }else if (!stack.isEmpty() && c == ')' && '(' == stack.pop()){
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution("()[]{}"));
        System.out.println(solution("]"));
    }
}
