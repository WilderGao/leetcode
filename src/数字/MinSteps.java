package 数字;

/**
 * @author WilderGao
 * time 2019-10-22 17:17
 * motto : everything is no in vain
 * description leetcode 650:
 * 描述：最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 */
public class MinSteps {
    public int solution(int n) {
        int res = 0;
        for (int i = 2; i <= n; ++i) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinSteps().solution(25));
    }
}
