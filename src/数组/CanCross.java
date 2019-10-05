package 数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author WilderGao
 * time 2019-10-05 09:40
 * motto : everything is no in vain
 * description leetcode 403
 */
public class CanCross {
    public static boolean solution(int[] stones) {
        if (stones == null || stones.length <= 1) return true;
        if (stones[1] - stones[0] != 1) return false;
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        return canCrossHelp(1, 1, stones.length - 1, stones, map);
    }

    /**
     * AC不了，时间复杂度太高（递归方式）
     *
     * @param startStep        跳跃的速度
     * @param index            已经到达的下标
     * @param length           石头数量
     * @param stones           石头数组
     * @param positionIndexMap 保存石头位置和数组下标的map
     * @return
     */
    private static boolean canCrossHelp(int startStep, int index, int length, int[] stones,
                                        Map<Integer, Integer> positionIndexMap) {
        if (index == length) return true;
        if (startStep == 0) return false;
        boolean result = false;
        if (positionIndexMap.containsKey(stones[index] + startStep)) {
            int i = positionIndexMap.get(stones[index] + startStep);
            result = canCrossHelp(startStep, i, length, stones, positionIndexMap);
        }
        if (!result && positionIndexMap.containsKey(stones[index] + startStep + 1)) {
            int i = positionIndexMap.get(stones[index] + startStep + 1);
            result = canCrossHelp(startStep + 1, i, length, stones, positionIndexMap);
        }
        if (!result && positionIndexMap.containsKey(stones[index] + startStep - 1)) {
            int i = positionIndexMap.get(stones[index] + startStep - 1);
            result = canCrossHelp(startStep - 1, i, length, stones, positionIndexMap);
        }
        return result;
    }

    /**
     * 利用dp方式来解决问题
     *
     * @param stones 石头数组
     * @return
     */
    public boolean solutionTwo(int[] stones) {
        int length = stones.length;
        int[] dp = new int[length];
        dp[0] = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>(32);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        map.put(0, set);
        int k = 0;
        for (int i = 1; i < length; i++) {
            while (dp[k] + 1 < stones[i] - stones[k]) {
                k++;
            }
            for (int j = k; j < i; j++) {
                int t = stones[i] - stones[j];
                if (map.get(j).contains(t) || map.get(j).contains(t - 1) || map.get(j).contains(t + 1)) {

                }
            }

        }
        return false;
    }


    public static void main(String[] args) {
        int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(solution(stones));
    }
}
