package 笔试题;

import java.util.*;

/**
 * @author WilderGao
 * time 2019-09-28 20:27
 * motto : everything is no in vain
 * description
 */
public class KuaiShouFour {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        List<Integer> weights = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            weights.add(in.nextInt());
        }
        while (weights.size() > 1) {
            int length = weights.size();
            Collections.sort(weights);
            int maxNum = weights.get(length - 1);
            int nextMaxNum = weights.get(length - 2);
            if (maxNum == nextMaxNum) {
                weights.remove(length - 1);
                weights.remove(length - 2);
            } else {
                weights.set(length - 2, maxNum - nextMaxNum);
                weights.remove(length - 1);
            }
        }
        System.out.println(weights.get(0));
    }

    class Node implements Comparable<Node>{

        @Override
        public int compareTo(Node o) {
            return 0;
        }
    }
}
