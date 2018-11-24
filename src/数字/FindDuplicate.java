package 数字;

import java.util.*;

/**
 * @author WilderGao
 * time 2018-11-24 22:20
 * motto : everything is no in vain
 * description 给定一个包含 n + 1 个整数的数组 nums，
 * 其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
public class FindDuplicate {
    /**
     * 我的话思路很简单，先把数组进行排序，然后遍历数组，判断如果前面一个数和后面一个数相等则就是这个数字重复
     *
     * @param nums 查找的数组
     * @return 重复的数字
     */
    public int solution(int[] nums) {
        int result = 0;
        List<Integer> numList = new LinkedList<>();
        for (int num : nums) {
            numList.add(num);
        }
        Collections.sort(numList);
        for (int i = 1; i < numList.size(); i++) {
            if (numList.get(i).equals(numList.get(i - 1))) {
                result = numList.get(i - 1);
                break;
            }
        }
        return result;
    }

    //然鹅......处理速度慢成狗，而且条件限制是不能对原有的数组进行修改，这就很尴尬了。于是有了以下比较不土的方法...

    /**
     * 使用二分法和鸽笼原理进行求解
     *
     * @param nums 查询数组
     * @return 重复的数字
     */
    public int solution2(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2, cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    ++cnt;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(new FindDuplicate().solution2(nums));
    }
}
