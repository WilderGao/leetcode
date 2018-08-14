package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wilder Gao
 * time:2018/8/12
 * description：给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *              candidates 中的数字可以无限制重复被选取。(回溯算法的实现）
 * motto: All efforts are not in vain
 */
public class ArraySum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new LinkedList<>();
        if (candidates == null){
            return result;
        }
        union(candidates, result, 0, target, new ArrayList<>());
        return result;
    }

    /**
     * 自己写一下回溯算法
     * @param candidates
     * @param result
     */
    private void union(int[] candidates, List<List<Integer>> result, int step, int target, List<Integer> nums){
        //代表添加之后的数值恰好为目标值
        if (target == 0){
            result.add(new ArrayList<>(nums));
            return;
        }
        //假如数组中的值比当前需要的值还大的话，则直接返回
        if (target< 0 || step >= candidates.length || target < candidates[step]) {
            return;
        }
        //进行深度优先搜索
        nums.add(candidates[step]);
        union(candidates, result, step, target - candidates[step], nums);
        //删除集合中最后一个值
        nums.remove(nums.size()-1);
        //继续深度优先搜索
        union(candidates, result, step +1, target, nums);

    }


    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        System.out.println(new ArraySum().combinationSum(candidates, 10));
    }
}
