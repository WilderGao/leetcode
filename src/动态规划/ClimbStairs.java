package 动态规划;

/**
 * @author Wilder Gao
 * time:2018/8/16
 * description：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * motto: All efforts are not in vain
 */
public class ClimbStairs {
    public int solution(int n) {
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().solution(5));
    }
}
