package 数字;


/**
 * @author WilderGao
 * time 2019-02-16 21:02
 * motto : everything is no in vain
 * description leetcode 53 最大自序和
 */
public class MaxSubArray {
    private int solutionOne(int[] nums) {
        if (nums == null) return 0;
        int nCurSum = 0;
        int nGreatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nCurSum <= 0) {
                //舍去前面的和
                nCurSum = nums[i];
            } else {
                nCurSum += nums[i];
            }
            if (nCurSum > nGreatestSum) {
                nGreatestSum = nCurSum;
            }
        }
        return nGreatestSum;
    }

}
