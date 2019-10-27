package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-24 20:57
 * motto : everything is no in vain
 * description leetcode 452 : 用最少数量的箭引爆气球
 */
public class FindMinArrowShots {
    public int solution(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        List<Node> pointList = new ArrayList<>();
        for (int[] point : points) {
            Node node = new Node(point[0], point[1]);
            pointList.add(node);
        }
        pointList.sort(((o1, o2) -> {
            if (o1.left == o2.left) {
                return o1.right - o2.right;
            }
            return o1.left - o2.left;
        }));
        int times = 1;
        int leftMax = Integer.MIN_VALUE;
        int rightMin = Integer.MAX_VALUE;
        for (Node iNode : pointList) {
            //找到射箭的范围
            if (iNode.left > rightMin) {
                //不可以通过
                times++;
                leftMax = iNode.left;
                rightMin = iNode.right;
            } else {
                leftMax = Math.max(leftMax, iNode.left);
                rightMin = Math.min(rightMin, iNode.right);
            }
        }
        return times;
    }

    class Node {
        int left;
        int right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}
        };
        System.out.println(new FindMinArrowShots().solution(points));
    }
}
