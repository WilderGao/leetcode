package 数字;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-03-06 01:00
 * motto : everything is no in vain
 * description leetcode 60
 */
public class GetPermutation {
    private String solution(int n, int k) {
        int[] factor = new int[n + 1];
        factor[0] = 1;
        for (int i = 1; i < factor.length; i++) {
            factor[i] = factor[i - 1] * i;
        }
        int num = 10;
        //先记录一下几个数字能产生几种排列
        List<Integer> numbers = new ArrayList<>(10);
        for (int i = 1; i < num; i++) {
            numbers.add(i);
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = n - 1; i <= 0; i--) {
            int numIndex = k / factor[i];
            k %= factor[i];
            resultBuilder.append(numbers.get(numIndex));
            numbers.remove(numIndex);
        }
        return resultBuilder.toString();
    }
}
