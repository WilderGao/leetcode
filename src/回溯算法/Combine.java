package 回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2018-12-10 19:51
 * motto : everything is no in vain
 * description 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 自己完成的，开心，leetcode 77
 */
public class Combine {
    public List<List<Integer>> solution(int n, int k){
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        combine(result, tmp, 1, n, k);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> tmp, int start, int end, int k){
        if (tmp.size() == k){
            //递归结束的标志，就是元素中数字的数量等于k
            List<Integer> index = new LinkedList<>(tmp);
            result.add(index);
            return;
        }

        for (int i = start; i <= end ; i++) {
            tmp.add(i);
            combine(result, tmp, i+1, end, k);
            tmp.remove(tmp.size() -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().solution(10,3));
    }
}
