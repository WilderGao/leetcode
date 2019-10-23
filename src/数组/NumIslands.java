package 数组;

/**
 * @author WilderGao
 * time 2019-10-18 21:09
 * motto : everything is no in vain
 * description leetcode : 岛屿的数量
 */
public class NumIslands {
    public int solution(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int weight = grid.length;
        int height = grid[0].length;
        boolean[][] visited = new boolean[weight][height];
        int num = 0;
        for (int i = 0; i < weight; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numIslandsHelp(grid, i, j, visited, height, weight);
                    num++;
                }
            }
        }
        return num;
    }

    private void numIslandsHelp(char[][] grid, int i, int j, boolean[][] visited, int height, int weight) {
        if (i < 0 || i >= weight || j < 0 || j >= height || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        //上下左右
        numIslandsHelp(grid, i - 1, j, visited, height, weight);
        numIslandsHelp(grid, i + 1, j, visited, height, weight);
        numIslandsHelp(grid, i, j - 1, visited, height, weight);
        numIslandsHelp(grid, i, j + 1, visited, height, weight);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new NumIslands().solution(grid));
    }
}
