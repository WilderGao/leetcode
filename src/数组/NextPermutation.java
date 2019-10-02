package 数组;

/**
 * @author WilderGao
 * time 2019-09-30 19:47
 * motto : everything is no in vain
 * description leetcode 31
 */
public class NextPermutation {
    private static void solution(int[] nums) {
        //思路：从最后边开始算起
        int nLength = nums.length;
        int i, j;
        for (i = nLength - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                for (j = nLength - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                //将right之后的数字反转
                reverse(nums, ++i, nLength - 1);
                return;
            }
        }
        reverse(nums, 0, nLength - 1);
    }

    private static void reverse(int[] nums, int begin, int end) {
        while (begin <= end) {
            int change = nums[begin];
            nums[begin] = nums[end];
            nums[end] = change;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        solution(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
