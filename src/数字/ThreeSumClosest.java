package 数字;

import java.util.Arrays;

/**
 * @author WilderGao
 * time 2019-01-08 15:00
 * motto : everything is no in vain
 * description
 * leetcode 16:给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    /**
     * 自己写的方法，先对数组排序，定义两个指针j和k，分别指向i+1和最末端的值，比较和target之前确定的最小距离，然后比较三个数加起来的值和target的大小
     * 如果小则j向后移动一位，反之k向前移动一位
     * @param nums 数组
     * @param target 目标值
     * @return 离target最近的三个数的和
     */
    public int solution(int[] nums, int target) {
        int tmpMin = Integer.MAX_VALUE;
        int tmpValue = 0;
        Arrays.sort(nums);
        int j, k, sum;
        for (int i = 0; i < nums.length; i++) {
            j = i + 1;
            k = nums.length - 1;
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < tmpMin) {
                    tmpValue = sum;
                    tmpMin = Math.abs(target - sum);
                }
                if (target > sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return tmpValue;
    }



    public static void main(String[] args) {
        int[] a = new int[]{-1,2,1,-4};
        int target = 1;
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.solution(a,target));
    }
}
