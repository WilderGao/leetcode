package 数组;


import java.util.*;

/**
 * @author WilderGao
 * time 2019-10-20 16:25
 * motto : everything is no in vain
 * description leetcode 1042: 不邻接植花
 */
public class GardenNoAdj {
    public int[] solution(int n, int[][] paths) {
        Map<Integer, List<Integer>> relationMap = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            relationMap.put(i, new ArrayList<>());
        }
        for (int[] path : paths) {
            relationMap.get(path[0]).add(path[1]);
            relationMap.get(path[1]).add(path[0]);
        }
        int[] result = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : relationMap.entrySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            for (Integer v : entry.getValue()) {
                list.remove(new Integer(result[v - 1]));
            }
            result[entry.getKey() - 1] = list.get(0);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] paths = new int[][]{
                {1, 2}, {3, 4}
        };
        for (int i : new GardenNoAdj().solution(4, paths)) {
            System.out.print(i + " ");
        }
    }
}


