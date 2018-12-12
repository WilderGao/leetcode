package 数字;

/**
 * @author wilder
 * @date 18-12-12 下午7:38
 * description  假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。
 */
public class FindMin {
    /**
     * 旋转的数组可以通过二分法来查找最小的元素，在数组的前后分别设置两个指针
     * @param nums 查询的数组
     * @return  最小的数
     */
    public int solution(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        //开始用二分法查找
        if (nums[left] <= nums[right])
            return nums[left];
        while(left != right-1){
            mid = (left + right)/2;
            if (nums[mid] < nums[left]){
                right = mid;
            }else {
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
