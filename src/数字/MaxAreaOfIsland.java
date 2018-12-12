package 数字;

/**
 * @author wilder
 * @date 18-12-12 下午8:51
 * description leetcode 695
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 *  示例 [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 *  输出结果是 6
 */
public class MaxAreaOfIsland {
    //遇到0就直接pass，遇到1就四方进行递归操作
    //这里用数组的原因是因为java的值传递和引用传递，我用int类型总是变成值传递所以结果老是为0
    private static int[] result = {0};
    private static int[] count = {0};
    public int solution(int[][] grid){
        //对每个点进行遍历
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count[0] = 0;
                    helper(grid, i, j, count, result);
                }
            }
        }
        return result[0];
    }

    private void helper(int[][] grid, int i, int j, int[] count, int[] result){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || i>=m || j<0 || j>=n || grid[i][j]<=0) return;
        count[0]++;
        result[0] = Math.max(result[0], count[0]);
        //走过的路记录点为-1
        grid[i][j] = -1;
        //对他周围的四个点进行递归
        helper(grid, i-1, j, count, result);
        helper(grid, i+1, j, count, result);
        helper(grid, i, j-1, count, result);
        helper(grid, i, j+1, count, result);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new MaxAreaOfIsland().solution(grid));
    }
}
