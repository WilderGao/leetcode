package 数字;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-01-08 15:20
 * motto : everything is no in vain
 * description  leetcode 15
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        //先对数组进行排序
        Arrays.sort(nums);
        int j, k;
        //后续定义两个指针，一个在i+1,一个在数组尾部
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    //小于0则j要向右移一位
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2, 0, 1, 1, 2};
        System.out.println(new ThreeSum().solution(a));
    }
}
