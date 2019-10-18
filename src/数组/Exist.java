package 数组;

/**
 * @author WilderGao
 * time 2019-10-17 10:20
 * motto : everything is no in vain
 * description leetcode 79: 单词搜索
 */
public class Exist {
    public boolean solution(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int weight = board.length, height = board[0].length;
        boolean[][] vistited = new boolean[weight][height];
        for (int i = 0; i < weight; i++) {
            for (int j = 0; j < height; j++) {
                if (existHelp(board, word, 0, i, j, vistited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existHelp(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean result = existHelp(board, word, index + 1, i - 1, j, visited)
                || existHelp(board, word, index + 1, i + 1, j, visited)
                || existHelp(board, word, index + 1, i, j - 1, visited)
                || existHelp(board, word, index + 1, i, j + 1, visited);
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new Exist().solution(board, "SEE"));
    }
}
