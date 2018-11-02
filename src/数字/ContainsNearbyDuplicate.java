package 数字;

import java.util.HashSet;
import java.util.Set;

/**
 * @author WilderGao
 * time 2018-10-25 11:27
 * motto : everything is no in vain
 * description
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsNearbyDuplicate {
    final Set<Integer> distinct = new HashSet<Integer>();

    public boolean solution(int[] nums, int k) {
        int length = nums.length;
        for (int i = 0; i <= k && i < length; i++) {
            if (distinct.contains(nums[i])) {
                return true;
            }
            distinct.add(nums[i]);
        }

        for (int j = k + 1; j < length; j++) {
            distinct.remove(nums[j-k-1]);
            if (distinct.contains(nums[j])){
                return true;
            }
            distinct.add(nums[j]);
        }
        return false;

    }

}
