package 数字;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-10-16 09:56
 * motto : everything is no in vain
 * description leetcode 386 字典序排数（利用数字排列的十叉树来解决）
 */
public class LexicalOrder {
    public static List<Integer> solution(int n) {
        if (n <= 0) return null;
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 9; i > 0; i--) {
            if (i <= n) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            result.add(top);
            for (int i = 9; i >= 0; i--) {
                if (top * 10 + i <= n) {
                    stack.push(top * 10 + i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(13));
    }
}
