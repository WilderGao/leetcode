package 数字;

/**
 * @author WilderGao
 * time 2019-01-15 14:18
 * motto : everything is no in vain
 * description leetcode 48
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 */
public class Rotate {
    private void solution(int[][] matrix) {
        int length = matrix.length - 1;
        if (length <= 0) return;
        int temp;
        for (int i = 0; i < (length + 1) / 2; i++) {
            for (int j = i; j < length - i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[length - j][i];
                matrix[length - j][i] = matrix[length - i][length - j];
                matrix[length - i][length - j] = matrix[j][length - i];
                matrix[j][length - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        new Rotate().solution(a);
    }
}
