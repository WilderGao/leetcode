package 数组;

/**
 * @author WilderGao
 * time 2019-10-03 16:40
 * motto : everything is no in vain
 * description leetcode 122: 买股票的最佳时机2
 */
public class MaxProfitII {
    public static int solution(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        int min = prices[0];
        int tmpProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                //重新置为0，将前面的结果加入
                profit += tmpProfit;
                min = prices[i];
                tmpProfit = 0;
                continue;
            }
            min = Math.min(min, prices[i]);
            tmpProfit = Math.max(tmpProfit, prices[i] - min);
        }
        return profit + tmpProfit;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(solution(a));
    }
}
