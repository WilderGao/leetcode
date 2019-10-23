package 数组;

/**
 * @author WilderGao
 * time 2019-10-19 13:56
 * motto : everything is no in vain
 * description:给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class Search {
    public static int solution(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        while (i < j) {
            mid = (i + j) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(solution(a, 9));
    }
}
