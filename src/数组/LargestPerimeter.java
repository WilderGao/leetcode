package 数组;

import java.util.Arrays;

/**
 * @author WilderGao
 * time 2019-10-19 14:33
 * motto : everything is no in vain
 * description leetcode 976: 三角形的最大周长
 */
public class LargestPerimeter {
    public int solution(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        Arrays.sort(A);
        int length = A.length;
        int k = length - 1;
        int j = k - 1;
        int i = j - 1;
        while (i >= 0) {
            if (check(A, i, j, k)) {
                return A[i] + A[j] + A[k];
            }
            i--;
            j--;
            k--;
        }
        return 0;
    }

    private boolean check(int[] A, int i, int j, int k) {
        if (A[i] + A[j] <= A[k]) {
            return false;
        }
        return A[k] - A[i] < A[j] && A[k] - A[j] < A[i];
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 3, 4};
        System.out.println(new LargestPerimeter().solution(a));
    }
}
