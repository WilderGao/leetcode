package 数字;

/**
 * @author WilderGao
 * time 2019-10-04 19:31
 * motto : everything is no in vain
 * description leetcode 625最小因式分解(a大于0）
 */
public class SmallestFactorization {
    public static int solution(int a) {
        if (a > 0 && a < 10) return a;
        StringBuilder resultBuilder = new StringBuilder();
        int index = 9;
        while (a > 1 && index > 1) {
            if (a % index == 0) {
                resultBuilder.append(index);
                a /= index;
            } else {
                index--;
            }
        }
        String result = resultBuilder.reverse().toString();
        if (a != 1 || result.length() >= Integer.toString(Integer.MAX_VALUE).length() &&
                result.compareTo(Integer.toString(Integer.MAX_VALUE)) > 0) {
            return 0;
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        System.out.println(solution(11));
    }
}
