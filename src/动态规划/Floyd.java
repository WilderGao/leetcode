package 动态规划;

/**
 * @author wilder
 * @date 19-1-16 下午12:57
 * description 佛洛依德算法
 */
public class Floyd {
    private int[][] solution(int[][] matrix){
        int length = matrix.length;
        int[][] tmpResult = matrix;
        for (int k = 0; k< length; k++) {
            int[][] updateMatrix = new int[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    updateMatrix[i][j] = Math.min(tmpResult[i][j], tmpResult[i][k]+tmpResult[k][j]);
                }
            }
            tmpResult = updateMatrix;
        }
        return tmpResult;
    }
}
