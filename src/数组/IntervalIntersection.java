package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-10-09 11:05
 * motto : everything is no in vain
 * description
 */
public class IntervalIntersection {
    public static int[][] solution(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return new int[0][0];
        int aLength = A.length, bLength = B.length;
        int i = 0, j = 0;
        List<int[]> resultList = new ArrayList<>();
        while (i < aLength && j < bLength) {
            int left = Math.max(A[i][0], B[j][0]);
            int right = Math.min(A[i][1], B[j][1]);
            if (left <= right) {
                resultList.add(new int[]{left, right});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] result = new int[resultList.size()][2];
        for (int k = 0; k < resultList.size(); k++) {
            result[k] = resultList.get(k);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        for (int[] ints : solution(A, B)) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
