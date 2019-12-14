package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-28 09:39
 * motto : everything is no in vain
 * description leetcode
 */
public class PermuteUnique {
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUniqueHelp(nums, 0, nums.length, result);
        return result;
    }

    private void permuteUniqueHelp(int[] nums, int start, int length, List<List<Integer>> result) {
        if (start >= length) {
            List<Integer> resultIndex = new ArrayList<>();
            for (int num : nums) {
                resultIndex.add(num);
            }
            if (!result.contains(resultIndex)) {
                result.add(resultIndex);
            }
            return;
        }
        for (int i = start; i < length; i++) {
            if (i != start && nums[i] == nums[start]) {
                continue;
            }
            swap(nums, start, i);
            permuteUniqueHelp(nums, start + 1, length, result);
            swap(nums, start, i);
        }
    }


    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1};
        for (List<Integer> list : new PermuteUnique().solution(nums)) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
