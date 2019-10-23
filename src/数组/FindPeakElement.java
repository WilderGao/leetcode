package 数组;

/**
 * @author WilderGao
 * time 2019-10-22 16:40
 * motto : everything is no in vain
 * description leetcode：找峰值元素（时间复杂度为O(logN)）
 */
public class FindPeakElement {
    public int solution(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        return findPeakElementHelp(nums, 0, nums.length - 1);
    }

    private int findPeakElementHelp(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        int mid = (left + right) / 2;
        if (mid - 1 >= -1 && mid + 1 <= nums.length) {
            if (mid - 1 >= 0 && mid + 1 < nums.length && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid == 0 && nums[mid + 1] < nums[mid] || mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            }
        }
        int resultLeft = findPeakElementHelp(nums, left, mid - 1);
        if (resultLeft != 0) {
            return resultLeft;
        }
        return findPeakElementHelp(nums, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new FindPeakElement().solution(nums));
    }
}
