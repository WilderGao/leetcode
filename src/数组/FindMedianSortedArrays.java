package 数组;

/**
 * @author WilderGao
 * time 2019-10-05 15:39
 * motto : everything is no in vain
 * description leetcode 4 : log(m+n) 求出排序数组的中位数
 */
public class FindMedianSortedArrays {
    public double solution(int[] num1, int[] num2) {
        int m = num1.length;
        int n = num2.length;
        int left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findPath(num1, 0, num2, 0, left) + findPath(num1, 0, num2, 0, right)) / 2.0;
    }

    /**
     * 找两个数组中第k个值
     *
     * @param num1 数组1
     * @param i    当前到达下标
     * @param num2 数组2
     * @param j    数组2当前到达下标
     * @param k    查找第k大的数
     * @return 结果
     */
    private int findPath(int[] num1, int i, int[] num2, int j, int k) {
        if (i >= num1.length) {
            return num2[j + k - 1];
        }
        if (j >= num2.length) {
            return num1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(num1[i], num2[j]);
        }
        //找每个数组第 k/2 个数的值
        int midValue1 = (i + k / 2 - 1 < num1.length) ? num1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midValue2 = (j + k / 2 - 1 < num2.length) ? num2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midValue1 < midValue2) {
            return findPath(num1, i + k / 2, num2, j, k - k / 2);
        }
        return findPath(num1, i, num2, j + k / 2, k - k / 2);
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3, 4};
        System.out.println(new FindMedianSortedArrays().solution(num1, num2));
    }
}
