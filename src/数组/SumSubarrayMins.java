package 数组;

import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-10-29 14:54
 * motto : everything is no in vain
 * description leetcode 907: 子数组的最小值之和
 */
public class SumSubarrayMins {
    private int pow = (int) Math.pow(10, 9) + 7;

    public int solution(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int result = 0;
        int length = a.length;
        Stack<Integer> positionStack = new Stack<>();
        positionStack.push(-1);
        int[] dp = new int[length + 1];
        for (int i = 0; i < length; i++) {
            while (positionStack.peek() != -1 && a[i] <= a[positionStack.peek()]) {
                positionStack.pop();
            }
            dp[i + 1] = (dp[positionStack.peek() + 1] + (i - positionStack.peek()) * a[i]) % pow;
            positionStack.push(i);
            result = (result + dp[i + 1]) % pow;
        }
        return result;
    }
}
