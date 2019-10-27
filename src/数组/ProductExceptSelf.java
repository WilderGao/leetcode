package 数组;

import java.util.Arrays;

/**
 * @author WilderGao
 * time 2019-10-23 09:42
 * motto : everything is no in vain
 * description leetcode 238: 除自身以外数组的乘积（不能用除法，时间复杂度为O(n)）
 */
public class ProductExceptSelf {

    /**
     * fwd中装的是第i个元素左边元素的乘积，比如[1,2,3,4] 当i=2的时候就是num[0]*num[1] = 2
     * 而bwd中装的是第i个元素右边元素的乘积
     * 那么结果就是当前元素位置左边乘积 * 右边乘积
     *
     * @param nums
     * @return
     */
    public int[] solution(int[] nums) {
        int length = nums.length;
        int[] fwd = new int[length];
        int[] bwd = new int[length];
        int[] res = new int[length];

        Arrays.fill(fwd, 1);
        Arrays.fill(bwd, 1);

        for (int i = 0; i < length - 1; i++) {
            fwd[i + 1] = fwd[i] * nums[i];
        }
        for (int i = length - 1; i > 0; i--) {
            bwd[i - 1] = bwd[i] * nums[i];
        }
        for (int i = 0; i < length; i++) {
            res[i] = fwd[i] * bwd[i];
        }
        return res;
    }


    /**
     * 方法二：不需要开辟新的空间（直接在result数组中进行操作得到结果，通过一个变量来记录中间结果）
     *
     * @param nums nums数组
     * @return 结果数组
     */
    public int[] solutionTwo(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, 1);
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        //现在res保存的是i下标左边值的乘积
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            //right其实保存的是i右边值的乘积
            right = right * nums[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        for (int i : new ProductExceptSelf().solutionTwo(nums)) {
            System.out.println(i + " ");
        }
    }
}
