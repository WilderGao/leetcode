package 数字;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-01-10 14:57
 * motto : everything is no in vain
 * description leetcode 18
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与
 * target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        int j, k;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            int targetNow = target - nums[i];
            for (int l = i+1; l < nums.length; l++) {
                j = l + 1;
                k = nums.length - 1;
                while (j < k){
                    if (nums[l] + nums[j] + nums[k] == targetNow) {
                        result.add(Arrays.asList(nums[i], nums[l],nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    } else if (nums[l] + nums[j] + nums[k] < targetNow) {
                        //小于0则j要向右移一位
                        j++;
                    } else if (nums[l] + nums[j] + nums[k] > targetNow) {
                        k--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;
        System.out.println(new FourSum().fourSum(nums, target));
    }
}
