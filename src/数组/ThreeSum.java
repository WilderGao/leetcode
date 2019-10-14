package 数组;

import java.util.*;

/**
 * @author WilderGao
 * time 2019-10-06 19:53
 * motto : everything is no in vain
 * description leetcode 15:三数之和
 */
public class ThreeSum {
    public static List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        int length = nums.length;
        if (nums[0] > 0 || nums[length - 1] < 0) return new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) break;
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i], j = i + 1, k = length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    Integer[] resultIndexArray = new Integer[]{nums[i], nums[j], nums[k]};
                    resultList.add(Arrays.asList(resultIndexArray));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};
        for (List<Integer> list : solution(a)) {
            System.out.println(list);
        }
    }
}
