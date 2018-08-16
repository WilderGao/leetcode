package 动态规划;

/**
 * @author Wilder Gao
 * time:2018/8/16
 * description：
 * leetcode 62:一个机器人位于一个 m * n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * 问总共有多少条不同的路径？
 * motto: All efforts are not in vain
 */
public class UniquePaths {
    public int solution(int m, int n){
        int[][] result = new int[n][m];
        for (int i = 0; i< m; i++){
            result[0][i] = 1;
        }
        for (int i = 0; i< n; i++){
            result[i][0] = 1;
        }

        for (int i = 1;i< n; i++){
            for (int j = 1; j< m;j++){
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }
        return result[n-1][m-1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().solution(7,3));
    }
}
