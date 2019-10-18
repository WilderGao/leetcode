package 笔试题;

import java.util.Scanner;

/**
 * @author WilderGao
 * time 2019-10-16 19:22
 * motto : everything is no in vain
 * description
 */
public class HuaweiNewTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] road = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                road[i][j] = scanner.nextInt();
            }
        }

        if (road[0][0] == 0 || road[n - 1][n - 1] == 0) {
            System.out.println(-1);
            return;
        }
        int[][] dp = new int[n][n];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            if (dp[0][i - 1] == -1 || road[0][i] == 0) {
                dp[0][i] = -1;
            } else {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (dp[i - 1][0] == -1 || road[i][0] == 0) {
                dp[i][0] = -1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        //左上到右下的更新
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (road[i][j] == 0 || dp[i][j - 1] == -1 && dp[i - 1][j] == -1) {
                    dp[i][j] = -1;
                } else if (dp[i][j - 1] == -1) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else if (dp[i - 1][j] == -1) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        //右下到左上的更新
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (road[i][j] == 0) {
                    dp[i][j] = -1;
                    continue;
                }
                if (j - 1 >= 0 && dp[i][j - 1] != -1) {
                    if (dp[i][j] == -1) {
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
                if (i + 1 < n && dp[i + 1][j] != -1) {
                    if (dp[i][j] == -1) {
                        dp[i][j] = dp[i + 1][j] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                }
            }
        }
        //右上到左下的更新
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (road[i][j] == 0) {
                    dp[i][j] = -1;
                    continue;
                }
                if (j + 1 < n && dp[i][j + 1] != -1) {
                    if (dp[i][j] == -1) {
                        dp[i][j] = dp[i][j + 1] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                }
                if (i - 1 >= 0 && dp[i - 1][j] != -1) {
                    if (dp[i][j] == -1) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
