package 数组;

/**
 * @author WilderGao
 * time 2019-10-23 10:43
 * motto : everything is no in vain
 * description leetcode ： 取石头游戏
 */
public class StoneGame {
    public boolean solution(int[] piles) {
        return stoneGameHelp(piles, 0, piles.length - 1, 0, 0, 0);
    }

    /**
     * 直接扑街，AC 不了
     * @param piles
     * @param left
     * @param right
     * @param leftResult
     * @param rightResult
     * @param turn
     * @return
     */
    private boolean stoneGameHelp(int[] piles, int left, int right, int leftResult, int rightResult, int turn) {
        if (left > right) {
            return leftResult > rightResult;
        }
        if (turn == 0) {
            //0就代表是左边的拿
            boolean res = stoneGameHelp(piles, left + 1, right, leftResult + piles[left], rightResult, Math.abs(1 - turn));
            if (!res) {
                res = stoneGameHelp(piles, left, right - 1, leftResult + piles[right], rightResult, Math.abs(1 - turn));
            }
            return res;
        } else {
            //1就代表是右边的拿
            boolean res = stoneGameHelp(piles, left + 1, right, leftResult, rightResult + piles[left], Math.abs(1 - turn));
            if (!res) {
                res = stoneGameHelp(piles, left, right - 1, leftResult, rightResult + piles[right], Math.abs(1 - turn));
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 8, 6};
        System.out.println(new StoneGame().solution(nums));
    }
}
