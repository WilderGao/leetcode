package 数字;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WilderGao
 * time 2018-12-02 10:08
 * motto : everything is no in vain
 * description leetcode 1
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    /**
     * 暴力解法
     * @param nums 数组
     * @param target 目标值
     * @return
     */
    public int[] solution(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 通过map来降低循环次数，以空间换时间
     * @param nums
     * @param target
     * @return
     */
    public int[] solutionUpdate(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>(16);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target-nums[i], i);
        }
        return result;
    }
}
