package 数字;

/**
 * @author wilder
 * @date 19-1-18 下午2:58
 * description leetcode 215 找到第k个最大的整数
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class FindKthLargest {
    /**
     * 第一种用分治法的思想解决，但是我做的效率有点低，估计是循环处理的不好
     * @param nums
     * @param k
     * @return
     */
    private int solutionFirst(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int tmpIndex = partition(nums, start, end);
        while (tmpIndex + 1 != k) {
            if (start == tmpIndex) {
                //考虑到partition时候第一个数最大的情况，会陷入死循环
                start++;
            } else if (tmpIndex < k) {
                start = tmpIndex;
            } else {
                end = tmpIndex;
            }
            tmpIndex = partition(nums, start, end);
        }
        return nums[tmpIndex];
    }

    /**
     * 分治法，根据快速排序的思想，返回划分的那个数的下标
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            while (nums[end] <= tmp && start < end) {
                end--;
            }
            nums[start] = nums[end];
            while (nums[start] > tmp && start < end) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[end] = tmp;
        return end;
    }


    /**
     * 还有一种是基于二叉堆的思想，明天来试着写一下
     * @param nums
     * @param k
     * @return
     */
    public int solutionSecond(int[] nums, int k){
        return 0;
    }

    
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new FindKthLargest().solutionFirst(a, 4));
        int[] b = new int[]{5, 2, 4, 1, 3, 6, 0};
        System.out.println(new FindKthLargest().solutionFirst(b, 4));
    }
}
