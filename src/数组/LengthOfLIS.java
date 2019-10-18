package 数组;

/**
 * @author WilderGao
 * time 2019-10-17 10:58
 * motto : everything is no in vain
 * description leetcode 300: 最长上升子序列
 */
public class LengthOfLIS {
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution(nums));
    }
}
