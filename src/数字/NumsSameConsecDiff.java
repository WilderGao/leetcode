package 数字;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-03 14:05
 * motto : everything is no in vain
 * description leetcode 967：连续差相同的数字
 */
public class NumsSameConsecDiff {

    public static int[] solution(int n, int k) {
        StringBuilder resultBuilder = new StringBuilder();
        List<Integer> resultList = new ArrayList<>();
        int startIndex = n == 1 ? 0 : 1;
        for (int i = startIndex; i < 10; i++) {
            resultBuilder.append(i);
            numsSameConsecDiffHelp(n - 1, k, i, resultList, resultBuilder);
            resultBuilder.deleteCharAt(resultBuilder.length() - 1);
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private static void numsSameConsecDiffHelp(int n, int k, int lastNum, List<Integer> result, StringBuilder tmpBuilder) {
        if (n == 0) {
            result.add(Integer.parseInt(tmpBuilder.toString()));
            return;
        }
        if (lastNum - k >= 0) {
            tmpBuilder.append(lastNum - k);
            numsSameConsecDiffHelp(n - 1, k, lastNum - k, result, tmpBuilder);
            tmpBuilder.deleteCharAt(tmpBuilder.length() - 1);
        }
        //k=0就和上面的情况一样了
        if (lastNum + k <= 9 && k != 0) {
            tmpBuilder.append(lastNum + k);
            numsSameConsecDiffHelp(n - 1, k, lastNum + k, result, tmpBuilder);
            tmpBuilder.deleteCharAt(tmpBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        int[] result = solution(1, 0);
        for (int i : result) {
            System.out.print(i + "  ");
        }
    }
}
