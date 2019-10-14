package 动态规划;

import java.util.Stack;

/**
 * @author WilderGao
 * time 2019-10-11 14:59
 * motto : everything is no in vain
 * description leetcode 42 : 接雨水
 */
public class Trap {
    /**
     * 用栈来进行解决 https://www.jianshu.com/p/024d2e3c13e8
     *
     * @param height 每个阶段的高度
     * @return 承接的雨水数量
     */
    public static int solutionOne(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] >= height[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int pre = stack.pop();
                    if (!stack.isEmpty()) {
                        res += (Math.min(height[stack.peek()], height[i]) - height[pre])
                                * (i - stack.peek() - 1);
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }


    /**
     * 用动态规划来解决问题
     *
     * @param height 水槽高度
     * @return 接水容量
     */
    public static int solutionTwo(int[] height) {
        if (height == null || height.length == 0) return 0;
        int length = height.length;
        int max = 0, res = 0;
        int[] dp = new int[length];
        //获得当前位置左边最大的高度
        for (int i = 0; i < length; i++) {
            dp[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = length - 1; i >= 0; i--) {
            int min = Math.min(max, dp[i]);
            max = Math.max(max, height[i]);
            res += min - height[i] > 0 ? min - height[i] : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solutionOne(a));
        System.out.println(solutionTwo(a));
    }
}
