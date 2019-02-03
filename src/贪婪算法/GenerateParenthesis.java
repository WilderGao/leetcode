package 贪婪算法;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wilder
 * @date 19-2-2 下午4:20
 * description leetcode 22
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenthesis {
    private List<String> solution(int n) {
        if (n <= 0) return null;
        List<String> result = new LinkedList<>();
        String s = "";
        helper(n, n, result, s);
        return result;
    }

    private void helper(int left, int right, List<String> result, String s) {
        //不能出现右括号比左括号多的情况，这样不符合情况
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(s);
        } else {
            if (left > 0) helper(left - 1, right, result, s + "(");
            if (right > 0) helper(left, right - 1, result, s + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().solution(3));
    }
}
