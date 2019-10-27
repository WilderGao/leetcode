package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-23 15:31
 * motto : everything is no in vain
 * description leetcode :
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。
 * 示例:
 */
public class AllPathsSourceTarget {
    public List<List<Integer>> solution(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        allPathsSourceTargetHelp(graph, 0, tmp, result);
        return result;
    }

    private void allPathsSourceTargetHelp(int[][] graph, int index, List<Integer> tmp, List<List<Integer>> result) {
        if (index == graph.length - 1) {
            tmp.add(index);
            List<Integer> resultIndex = new ArrayList<>(tmp);
            result.add(resultIndex);
            return;
        }
        tmp.add(index);
        int[] graphIndex = graph[index];
        for (int nextIndex : graphIndex) {
            allPathsSourceTargetHelp(graph, nextIndex, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 2}, {3}, {3}, {}
        };
        List<List<Integer>> result = new AllPathsSourceTarget().solution(graph);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
