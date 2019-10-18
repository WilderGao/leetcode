package 数组;

/**
 * @author WilderGao
 * time 2019-10-14 17:05
 * motto : everything is no in vain
 * description leetcode 55 : 跳跃游戏
 */
public class CanJump {
    public static boolean solution(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        return canJumpHelp(nums, 0, dp);
    }

    /**
     * 凉凉，没有AC，超时了
     *
     * @param nums         跳跃数组
     * @param currentIndex 当前位置
     * @return 是否可以到达
     */
    private static boolean canJumpHelp(int[] nums, int currentIndex, int[] dp) {
        if (dp[currentIndex] != 0) {
            return dp[currentIndex] == 1;
        }
        int maxStep = Math.min(nums[currentIndex], nums.length);
        boolean result;
        for (int i = 1; i <= maxStep; i++) {
            result = canJumpHelp(nums, currentIndex + i, dp);
            if (result) {
                dp[currentIndex] = 1;
                return true;
            }
        }
        dp[currentIndex] = -1;
        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(solution(nums));
    }
}
