package 数字;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2018-11-23 18:00
 * motto : everything is no in vain
 * description leetcode78，求给定一组不含重复元素的整数数组nums,返回该数组所有可能的子集
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> index = new LinkedList<>();
                index.addAll(result.get(j));
                result.add(index);
                List<Integer> t = result.get(result.size()-1);
                t.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Subsets().solution(nums));
    }


}
