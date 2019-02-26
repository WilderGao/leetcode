package jianzhi;

import java.util.*;

/**
 * @author wilder
 * @date 19-2-26 下午8:47
 * description 把数组排成最小的数
 */
public class FortyFive {
    private String printMinNumber(int[] numbers){
        if (numbers == null) return null;
        //先把数组变成集合
        List<Integer> resultList = new ArrayList<>();
        for (int number : numbers) {
            resultList.add(number);
        }
        resultList.sort((integer, t1) -> {
            String compareA = integer+""+t1;
            String compareB = t1+""+integer;
            return compareA.compareTo(compareB);
        });
        StringBuilder result = new StringBuilder();
        for (Integer index : resultList) {
            result.append(index);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3,32,321};
        System.out.println(new FortyFive().printMinNumber(numbers));
    }
}
