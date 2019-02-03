package 动态规划;

/**
 * @author wilder
 * @date 19-1-16 上午11:17
 * description 通过Warshall算法来计算传递闭包
 */
public class Warshall {
    private int[][] solution(int[][] matrix){
        int length = matrix.length;
        int[][] tmpResult = matrix;
        for (int k = 0; k < length; k++) {
            int[][] updateMatrix = new int[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    updateMatrix[i][j] = tmpResult[i][j] | (tmpResult[i][k] & tmpResult[k][j]);
                }
            }
            tmpResult = updateMatrix;
        }
        return tmpResult;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,0,0},
                {0,0,0,1},
                {0,0,0,0},
                {1,0,1,0}
        };
        int[][] result = new Warshall().solution(matrix);
        for (int[] indexs : result) {
            for (int i : indexs) {
                System.out.print(i+"  ");
            }
            System.out.println();
        }
    }
}
