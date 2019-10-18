package 数组;

/**
 * @author WilderGao
 * time 2019-10-17 09:49
 * motto : everything is no in vain
 * description 题目：O(n)复杂度对只有0 1 2 的三个数组进行排序
 */
public class SortZeroOneTwo {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    public int[] solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < length && nums[left] == ZERO) {
            left++;
        }
        while (right >= 0 && nums[right] == TWO) {
            right--;
        }
        int cur = left;
        while (cur <= right) {
            if (nums[cur] == ONE) {
                cur++;
            } else if (nums[cur] == ZERO) {
                swap(nums, cur, left);
                left++;
            } else {
                swap(nums, cur, right);
                right--;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 1, 2, 0, 2, 0, 1, 2, 2, 2, 1, 2};
        nums = new SortZeroOneTwo().solution(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
