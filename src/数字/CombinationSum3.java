package 数字;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-26 21:04
 * motto : everything is no in vain
 * description leetcode 216: 数组总和Ⅲ
 */
public class CombinationSum3 {
    public List<List<Integer>> solution(int k, int n) {
        List<Integer> tmpList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelp(0, 0, k, 0, n, tmpList, result);
        return result;
    }

    private void combinationSumHelp(int number, int num, int k, int tmpNum, int target,
                                    List<Integer> tmpList, List<List<Integer>> result) {
        if (num == k && tmpNum == target) {
            List<Integer> rIndex = new ArrayList<>(tmpList);
            result.add(rIndex);
            return;
        } else if (num > k || tmpNum > target) {
            return;
        }
        for (int i = number + 1; i < 10; i++) {
            tmpList.add(i);
            combinationSumHelp(i, num + 1, k, tmpNum + i, target, tmpList, result);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum3().solution(3, 7);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
