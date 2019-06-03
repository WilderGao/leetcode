package 数字;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WilderGao
 * time 2019-06-03 20:11
 * motto : everything is no in vain
 * description leetcode 496
 * <p>
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * <p>
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 */
public class NextGreaterElement {
    /**
     * 使用哈希表来进行优化
     *
     * @param findNums 查询数组
     * @param nums     被查询数组
     * @return 查询结果数组
     */
    private int[] solution(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        //Map来确定数字和元素下标的映射，以后就可以直接获得元素的位置不需要遍历
        Map<Integer, Integer> numsIndexMap = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            numsIndexMap.put(nums[i], i);
        }
        for (int i = 0; i < findNums.length; i++) {
            result[i] = -1;
            int start = numsIndexMap.get(findNums[i]);
            for (int j = start + 1; j < nums.length; j++) {
                if (findNums[i] < nums[j]) {
                    result[i] = nums[j];
                    break;
                }
            }
        }
        return result;
    }
}
