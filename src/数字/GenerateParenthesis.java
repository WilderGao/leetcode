package 数字;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-21 19:13
 * motto : everything is no in vain
 * description leetcode 括号生成
 */
public class GenerateParenthesis {
    public List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        String s = "";
        generateParenthesisHelp(n, n, result, s);
        return result;
    }

    private void generateParenthesisHelp(int left, int right, List<String> result, String s) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) {
            generateParenthesisHelp(left - 1, right, result, s + "(");
        }
        if (right > 0) {
            generateParenthesisHelp(left, right - 1, result, s + ")");
        }
    }

    public static void main(String[] args) {
        List<String> result = new GenerateParenthesis().solution(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
