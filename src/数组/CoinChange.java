package 数组;

import java.util.Arrays;

/**
 * @author WilderGao
 * time 2019-10-18 13:41
 * motto : everything is no in vain
 * description leetcode 322 : 零钱兑换
 */
public class CoinChange {
    private static int MIN = 0;

    /**
     * 我想的是贪心算法，可是后面发现贪心算法不对，存在一些问题，应该要用动态规划才对吧
     *
     * @param coins
     * @param amount
     * @return
     */
    public int solution(int[] coins, int amount) {
        Arrays.sort(coins);
        MIN = 0;
        if (coinChangeHelp(coins, 0, amount, coins.length - 1)) {
            return MIN;
        }
        return -1;
    }

    private boolean coinChangeHelp(int[] coins, int currentAmount, int amount, int index) {
        if (index < 0 || currentAmount > amount) {
            return false;
        }
        if (currentAmount == amount) {
            return true;
        }
        for (int i = index; i >= 0; i--) {
            MIN++;
            if (coinChangeHelp(coins, currentAmount + coins[i], amount, i)) {
                return true;
            }
            MIN--;
        }
        return false;
    }


    /**
     * 使用优秀的动态规划来解决对应的问题
     *
     * @param coins  硬币数组
     * @param amount 凑的钱数
     * @return 最小硬币数量
     */
    public int solutionTwo(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5};
        int result = new CoinChange().solutionTwo(nums, 11);
        System.out.println(result);
    }
}
