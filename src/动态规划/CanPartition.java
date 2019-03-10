package 动态规划;

/**
 * @author WilderGao
 * time 2019-03-05 13:46
 * motto : everything is no in vain
 * description leetcode 416
 */
public class CanPartition {
    private boolean solution(int[] nums) {
        if (nums == null) {
            return false;
        }
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % 2 != 0) {
            return false;
        }
        target = target >> 1;
        int length = nums.length;
        boolean[][] result = new boolean[length + 1][target + 1];
        result[0][0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= target; j++) {
                result[i][j] = result[i - 1][j];
                if (j >= nums[i-1]){
                    result[i][j] = result[i-1][j] || result[i-1][j-nums[i-1]];
                }
            }
        }
        return result[length][target];
    }
}
