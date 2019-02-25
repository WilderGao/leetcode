package jianzhi;

import java.util.TreeSet;
import java.util.Vector;

/**
 * @author wilder
 * @date 19-2-25 下午5:17
 * description 所有子数组的和的最大值
 */
public class FortyTwo {
    private int findGreatestSumOfSubArray(int[] numbers){
        if (numbers == null) return 0;
        int tmpMax = 0, targetMax = 0;
        for (int number : numbers) {
            //如果前面的数字的和加起来小于0的话，那前面就没必要留着了直接舍去
            if (tmpMax <= 0){
                tmpMax = number;
            }else {
                //如果不小于0则加上新的值
                tmpMax += number;
            }
            if (tmpMax > targetMax){
                //加上之后这个就是如果比上一次的最大值要大，也就是说加上的值是个正数，那么要对最终结果进行修改
                targetMax = tmpMax;
            }
        }
        return targetMax;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(new FortyTwo().findGreatestSumOfSubArray(a));
    }
}
