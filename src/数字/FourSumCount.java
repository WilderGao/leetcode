package 数字;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WilderGao
 * time 2019-04-06 22:16
 * motto : everything is no in vain
 * description leetcode 454 四数相加
 */
public class FourSumCount {
    private int solution(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int a : A) {
            for (int b : B) {
                int sumAb = a + b;
                if (!map.containsKey(sumAb)) {
                    map.put(sumAb, 1);
                } else {
                    int index = map.get(sumAb);
                    index++;
                    map.put(sumAb, index);
                }
            }
        }
        int result = 0;
        for (int c : C) {
            for (int d : D) {
                int sumCd = -c - d;
                if (map.containsKey(sumCd)){
                    result += map.get(sumCd);
                }
            }
        }
        return result;
    }
}
