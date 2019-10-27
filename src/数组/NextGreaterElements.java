package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-24 21:21
 * motto : everything is no in vain
 * description leetcode 503： 下一个更大的元素Ⅱ
 */
public class NextGreaterElements {
    public int[] solution(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int num : nums) {
            list.add(num);
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) > nums[i]) {
                    result[i] = list.get(j);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        for (int i : new NextGreaterElements().solution(nums)) {
            System.out.print(i+" ");
        }
    }
}
