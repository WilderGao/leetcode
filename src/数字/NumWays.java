package 数字;

/**
 * @author WilderGao
 * time 2019-10-21 18:56
 * motto : everything is no in vain
 * description leetcode 276：栅栏涂色
 */
public class NumWays {
    public int solution(int n, int k) {
        if (n == 0) {
            return 0;
        }
        int same = 0;
        int diff = k;
        int res = same + diff;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = res * (k - 1);
            res = same + diff;
        }
        return res;
    }
}
