package 堆;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author WilderGao
 * time 2019-10-03 09:29
 * motto : everything is no in vain
 * description
 */
public class NetworkDelayTime {
    private static final int SIZE = 101;

    public int solution(int[][] times, int n, int k) {
        int[][] locations = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                locations[i][j] = -1;
            }
        }
        for (int[] time : times) {
            locations[time[0]][time[1]] = time[2];
        }
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[k] = 0;
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(k);
        while (!queue.isEmpty()) {
            Set<Integer> visited = new HashSet<>();
            for (int i = queue.size(); i > 0; i--) {
                int index = queue.poll();
                for (int j = 1; j < SIZE; j++) {
                    if (locations[index][j] != -1 && result[index] + locations[index][j] < result[j]) {
                        if (!visited.contains(j)) {
                            visited.add(j);
                            queue.add(j);
                        }
                        result[j] = result[index] + locations[index][j];
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < result.length; i++) {
            res = Math.max(res, result[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {2, 1, 1}, {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
        };
        System.out.println(new NetworkDelayTime().solution(a, 4, 2));
    }
}
