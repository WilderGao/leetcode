package 数字;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2018-11-26 17:20
 * motto : everything is no in vain
 * description leetcode 119
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 输入: 3
 * 输出: [1,3,3,1]
 * 要求：空间复杂度为 O（n），所以不能把每行都算出来
 */
public class GetRow {
    /**
     * 自己的方法永远都是那么的 row
     * @param rowIndex  行数
     * @return  第n行的结果
     */
    public List<Integer> solution(int rowIndex){
        List<Integer> preRowList = new LinkedList<>();
        preRowList.add(1);
        List<Integer> currentRowList = new LinkedList<>();
        for (int i = 1; i <= rowIndex; i++) {
            currentRowList.add(1);
            for (int j = 1; j < i; j++) {
                int num = preRowList.get(j - 1) + preRowList.get(j);
                currentRowList.add(num);
            }
            currentRowList.add(1);
            preRowList.clear();
            preRowList = currentRowList;
            currentRowList = new LinkedList<>();
        }
        return preRowList;
    }

    /**
     * 后来我看到了杨辉三角有这么一个特性 第n行的第k个数字为组合数C_{n-1}^{k-1}。
     * @param rowIndex
     * @return
     */
    public List<Integer> solutionUpdate(int rowIndex){
        List<Integer> result = new ArrayList<>(rowIndex);
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            //逐行覆盖当前集合位置的值，记得要从大到小遍历，因为新一次遍历后第n个数的值由上一次遍历n-1和n这两个数运算获得，如果先计算新一列的
            //第n-1位置的值，那么第n个数的值会受到影响。
            for (int j = result.size()-1; j > 0; j--) {
                int num = result.get(j-1) + result.get(j);
                result.set(j, num);
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GetRow().solutionUpdate(3));
    }
}
