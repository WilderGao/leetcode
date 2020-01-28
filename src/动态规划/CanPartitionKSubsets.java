package 动态规划;

import java.util.Arrays;

/**
 * @author wilder
 * @date 19-1-21 上午10:52
 * description leetcode 698
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * 示例 1：
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * 注意:
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 */
public class CanPartitionKSubsets {
    private boolean solution(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        //表示每一部分的和是sum/k
        int collect = sum / k;
        //给数组拍一下序，后面递归比较方便操作
        Arrays.sort(nums);
        //动态规划维护一个一维数组
        int[] v = new int[k];
        //只有当这个维护的一维数组v里面的值全都等于collect才会返回true
        return doAction(nums, v, nums.length - 1, collect);
    }

    private boolean doAction(int[] nums, int[] v, int index, int collect) {
        if (index == -1) {
            for (int i : v) {
                if (i != collect) return false;
            }
            return true;
        }
        int num = nums[index];
        for (int i = 0; i < v.length; i++) {
            if (v[i] + num > collect) continue;
            v[i] += num;
            if (doAction(nums, v, index - 1, collect)) return true;
            v[i] -= num;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(new CanPartitionKSubsets().solution(a, k));
    }
}
