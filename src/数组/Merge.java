package 数组;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-02 13:56
 * motto : everything is no in vain
 * description leetcode 56：区间合并
 */
public class Merge {
    public static int[][] solution(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        List<Node> nodes = new ArrayList<>();
        for (int[] interval : intervals) {
            Node node = new Node(interval[0], interval[1]);
            nodes.add(node);
        }
//        Collections.sort(nodes);

        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.left > o2.left) {
                    return 1;
                }
                return -1;
            }
        });

        List<Node> result = new ArrayList<>();
        result.add(nodes.get(0));
        for (int i = 1; i < nodes.size(); i++) {
            Node lastIndex = result.get(result.size() - 1);
            if (lastIndex.right < nodes.get(i).left) {
                //没有重叠，直接插入
                result.add(nodes.get(i));
            } else {
                lastIndex.right = Math.max(lastIndex.right, nodes.get(i).right);
            }
        }
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            int[] index = new int[2];
            index[0] = result.get(i).left;
            index[1] = result.get(i).right;
            resultArray[i] = index;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        for (int[] ints : solution(intervals)) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Node implements Comparable<Node> {
    int left;
    int right;

    Node(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return this.left - o.left;
    }
}
