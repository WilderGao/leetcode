package huisu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wilder Gao
 * time:2018/8/14
 * description：给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *              candidates 中的每个数字在每个组合中只能使用一次（每个数字有可能重复）。
 * motto: All efforts are not in vain
 */
public class ArraySum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> indexs = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        find(candidates, indexs, result, target, 0);
        return result;
    }

    private void find(int[] candidates, List<Integer> indexs, List<List<Integer>> result, int target, int step){
        for (int i = step; i < candidates.length; i++){
            if (target == candidates[i]){
                indexs.add(candidates[i]);
                result.add(new ArrayList<>(indexs));
                indexs.remove(indexs.size()-1);
                break;
            }

            if (target > candidates[i]){
                indexs.add(candidates[i]);
                find(candidates, indexs, result, target - candidates[i], i+1);
                indexs.remove(indexs.size()-1);

                while (i < candidates.length && candidates[i] == candidates[i+1]){
                    i++;
                }
            }
            if (candidates[i] > target){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1,2,2,2,5};
        System.out.println(new ArraySum2().combinationSum2(candidates, 5));
    }
}
