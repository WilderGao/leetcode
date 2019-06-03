package 数字;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author WilderGao
 * time 2019-06-03 20:53
 * motto : everything is no in vain
 * description leetcode 75 颜色分类
 */
public class SortColors {
    private static final int RED = 0;
    private static final int BLUE = 2;

    private void solution(int[] nums) {
        int start = 0, end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            if (nums[i] == RED) {
                swap(nums, i, start);
                start++;
            }else if (nums[i] == BLUE){
                swap(nums, i, end);
                i--;
                end--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 0, 2, 1, 1, 0, 0, 1, 2};
        new SortColors().solution(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
