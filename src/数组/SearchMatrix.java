package 数组;

/**
 * @author WilderGao
 * time 2019-10-09 10:54
 * motto : everything is no in vain
 * description
 */
public class SearchMatrix {
    public static boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int weight = matrix.length;
        int height = matrix[0].length;
        int i = weight - 1, j = 0;
        while (i >= 0 && j < height) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(solution(matrix, 20));
    }
}
