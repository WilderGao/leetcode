package 数字;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2018-12-13 15:31
 * motto : everything is no in vain
 * description leetcode 442
 */
public class FindDuplicates {
    public List<Integer> solution(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //这里是采用将第i个数与
            int idx = Math.abs(nums[i])-1;
            if (nums[idx] < 0) {
                result.add(idx + 1);
            }
            nums[idx] = -nums[idx];
        }
        return result;
    }

}
