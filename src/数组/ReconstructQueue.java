package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-26 09:53
 * motto : everything is no in vain
 * description leetcode: 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且
 * 身高大于或等于h的人数。 编写一个算法来重建这个队列。
 */
public class ReconstructQueue {

    /**
     * 当时头条就问了这道题，妈的
     *
     * @param people
     * @return
     */
    public int[][] solution(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return people;
        }
        List<Node> peopleList = new ArrayList<>(people.length);
        for (int[] person : people) {
            Node node = new Node(person[0], person[1]);
            peopleList.add(node);
        }
        peopleList.sort((o1, o2) -> {
            if (o1.left == o1.right) {
                return o1.right - o2.right;
            }
            return o2.left - o1.left;
        });
        for (int i = 0; i < peopleList.size(); i++) {
            Node node = peopleList.get(i);
            peopleList.remove(node);
            peopleList.add(node.right, node);
        }

        int[][] result = new int[peopleList.size()][2];
        for (int i = 0; i < result.length; i++) {
            Node node = peopleList.get(i);
            result[i] = new int[]{node.left, node.right};
        }
        return result;
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
        int[][] people = new int[][]{
                {3, 0}, {6, 0}, {7, 0}, {5, 2}, {3, 4}, {6, 2}, {5, 3}, {2, 7}, {9, 0}, {1, 9}
        };
        for (int[] ints : new ReconstructQueue().solution(people)) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
