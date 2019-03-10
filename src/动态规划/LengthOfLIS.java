package 动态规划;

/**
 * @author WilderGao
 * time 2019-03-05 14:04
 * motto : everything is no in vain
 * description leetcode 300
 */
public class LengthOfLIS {
    private int solution(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = 1;
        }
        //起码都得有一个长度吧
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : result) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LengthOfLIS().solution(a));
    }
}
