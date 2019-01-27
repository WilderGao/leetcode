package 数字;

/**
 * @author WilderGao
 * time 2018-10-25 13:05
 * motto : everything is no in vain
 * description leetcode 220
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
//public class ContainsNearbyAlmostDuplicate {
//
//    public boolean solution(int[] nums, int k, int t) {
//        int length = nums.length;
//        int max , min;
//        for (int i = 0; i < length - k; i++) {
//            max = nums[i];
//            min = nums[i];
//            for (int j = i; j <= i + k; j++) {
//                if (max<nums[j]) max = nums[j];
//                if (min>nums[j]) min = nums[j];
//            }
//            if (max - min >= t) return true;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {1,0,1,1};
//        System.out.println(new ContainsNearbyAlmostDuplicate().solution(nums, 1, 2));
//    }
//}
