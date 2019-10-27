package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author WilderGao
 * time 2019-10-23 15:52
 * motto : everything is no in vain
 * description leetcode : 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 */
public class LargestNumber {
    public String solution(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort(((o1, o2) -> {
            String o1o2 = o1 + o2;
            String o2o1 = o2 + o1;
            return o2o1.compareTo(o1o2);

        }));
        if (list.get(0).equals("0")){
            return list.get(0);
        }
        StringBuilder resB = new StringBuilder();
        for (String s : list) {
            resB.append(s);
        }
        return resB.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(new LargestNumber().solution(nums));
    }
}
