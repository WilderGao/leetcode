package 数组;

/**
 * @author WilderGao
 * time 2019-10-02 16:11
 * motto : everything is no in vain
 * description
 */
public class MaxSubArray {
    public static int solution(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            //如果前面的和小于0，那就直接废弃掉
            if (currentSum < 0) {
                currentSum = num;
            } else {
                currentSum += num;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution(nums));
    }
}
