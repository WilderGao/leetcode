package 回溯算法;

import java.util.*;

/**
 * @author WilderGao
 * time 2018-10-12 10:58
 * motto : everything is no in vain
 * description 全排列算法的实现
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 去除重复的排列
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Permute {
    public List<List<Integer>> solution(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        perm(nums, 0, nums.length, result);
        return result;
    }

    private void perm(int[] nums, int p, int q, List<List<Integer>> result){
        if (p == q){
            //递归结束条件
             List<Integer> tmp = new LinkedList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            result.add(tmp);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = p; i < q; i++){
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums, p, i);
            perm(nums, p+1, q, result);
            swap(nums, p, i);
        }
    }

    private void swap(int[] nums, int p, int q){
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(new Permute().solution(nums));
    }
}
