package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-05 20:20
 * motto : everything is no in vain
 * description leetcode 135:分发糖果
 */
public class Candy {
    public static int solution(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int[] appleNumArray = new int[ratings.length];
        int candyNumIndex = 1;
        //先给每个节点评分，递增分数增加，否则继续从1开始
        for (int i = 0; i < ratings.length; i++) {
            if (i - 1 >= 0 && ratings[i] <= ratings[i-1]){
                candyNumIndex = 1;
            }
            appleNumArray[i] = candyNumIndex++;
        }
        //处理边界问题，如果边界的分数比他大，那么他获得的数量应该是分数小的+1
        for (int i = appleNumArray.length - 1; i >= 0; i--) {
            if (i - 1 >= 0 && ratings[i - 1] > ratings[i] && appleNumArray[i - 1] <= appleNumArray[i]) {
                appleNumArray[i - 1] = appleNumArray[i] + 1;
            }
        }
        int result = 0;
        for (int num : appleNumArray) {
            result += num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4, 5, 2};
        System.out.println(solution(a));
    }
}
