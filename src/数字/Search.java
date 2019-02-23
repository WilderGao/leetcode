package 数字;

/**
 * @author WilderGao
 * time 2019-02-21 19:31
 * motto : everything is no in vain
 * description leetcode 33 搜索旋转排序数组
 */
public class Search {
    private int solution(int[] nums, int target) {
        if (nums != null) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                int mid = (left + right) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] < nums[right]){
                    //证明mid右边是单调递增的
                    if (nums[mid] < target && nums[right] >= target){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }else {
                    //则left到mid是单调的
                    if (nums[mid] > target && nums[left] <= target){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
