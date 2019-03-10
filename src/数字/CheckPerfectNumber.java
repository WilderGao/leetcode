package 数字;

/**
 * @author wilder
 * @date 19-3-2 下午2:34
 * description leetcode 507
 */
public class CheckPerfectNumber {
    private boolean solution(int num) {
        if (num == 1) return false;
        int i = 2, result = 0;
        while (i * i <= num) {
            if (num % i == 0) {
                result += i;
                result += num / i;
            }
            i++;
        }
        result += 1;
        return result == num;
    }
}
