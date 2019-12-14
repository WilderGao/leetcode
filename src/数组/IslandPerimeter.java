package 数组;

/**
 * @author WilderGao
 * time 2019-10-29 14:15
 * motto : everything is no in vain
 * description leetcode
 */
public class IslandPerimeter {
    public int solution(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        result--;
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        result--;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        result--;
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        result--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(new IslandPerimeter().solution(grid));
    }
}
