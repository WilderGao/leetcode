package 数组;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-21 19:32
 * motto : everything is no in vain
 * description leetcode 354 : 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 */
public class MaxEnvelopes {
    /**
     * 排序 + 动态规划的方法解决问题
     *
     * @param envelopes 信封数组
     * @return 最多组成套娃信封的数量
     */
    public int solution(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        List<Node> list = new LinkedList<>();
        for (int[] envelope : envelopes) {
            list.add(new Node(envelope[0], envelope[1]));
        }
        list.sort((o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o1.height - o2.height;
            }
            return o1.weight - o2.weight;
        });

        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            Node currentNode = list.get(i);
            for (int j = 0; j < i; j++) {
                Node jNode = list.get(j);
                if (currentNode.weight > jNode.weight && currentNode.height > jNode.height) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return dp[envelopes.length - 1];
    }

    public int solutionTwo(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        List<Node> list = new ArrayList<>();
        for (int[] envelope : envelopes) {
            list.add(new Node(envelope[0], envelope[1]));
        }
        list.sort((o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.height - o1.height;
            }
            return o1.weight - o2.weight;
        });
        int[] height = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            height[i] = list.get(i).height;
        }
        return lengthOfLIS(height);
    }

    /**
     * 用二分法求最长递增子序列
     *
     * @param nums 数组
     * @return 最长结果
     */
    private int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = num;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == num) {
                num++;
            }
            top[left] = nums[i];
        }
        return num;
    }


    class Node {
        int weight;
        int height;

        public Node(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{
                {5,4},{6,4},{6,7},{2,3}
        };
        System.out.println(new MaxEnvelopes().solutionTwo(envelopes));
    }
}
