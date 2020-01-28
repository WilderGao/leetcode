package 字符串;

import java.util.Stack;

/**
 * @author WilderGao
 * time 2020-01-28 16:14
 * motto : everything is no in vain
 * description leetcode
 */
public class BackspaceCompare {
    private boolean solution(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                sStack.push(c);
            } else {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c != '#') {
                tStack.push(c);
            } else {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            }
        }
        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            if (!sStack.pop().equals(tStack.pop())) {
                return false;
            }
        }
        if (sStack.isEmpty() && !tStack.isEmpty() || !sStack.isEmpty() && tStack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "xywrrmp";
        String t = "xywrrmu#p";
        System.out.println(new BackspaceCompare().solution(s, t));
    }
}
