package 数字;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2018-11-26 16:42
 * motto : everything is no in vain
 * description leetcode 118
 * 杨辉三角实现，输入层数n返回杨辉三角
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Generate {
    public List<List<Integer>> solution(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(new LinkedList<>());
        result.get(0).add(1);

        //一行一行遍历进行插入
        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRowList = new LinkedList<>();
            currentRowList.add(1);
            List<Integer> preRowList = result.get(i-1);
            for (int j = 1; j < i; j++) {
                int num = preRowList.get(j - 1) + preRowList.get(j);
                currentRowList.add(num);
            }
            currentRowList.add(1);
            result.add(currentRowList);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Generate().solution(10));
    }
}
