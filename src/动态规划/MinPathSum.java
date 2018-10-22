package 动态规划;

/**
 * @author WilderGao
 * time 2018-10-22 16:59
 * motto : everything is no in vain
 * description 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {
    public int solution(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = grid[0][0];
                } else if (i == 0) {
                    result[i][j] = grid[i][j] + result[i][j - 1];
                } else if (j == 0) {
                    result[i][j] = grid[i][j] + result[i - 1][j];
                } else {
                    result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
                }
            }
        }

        return result[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,5},{3,2,1}};
        System.out.println(new MinPathSum().solution(a));
    }
}
