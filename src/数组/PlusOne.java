package 数组;

/**
 * @author WilderGao
 * time 2019-10-27 14:23
 * motto : everything is no in vain
 * description leetcode
 */
public class PlusOne {
    public int[] solution(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int length = digits.length;
        int plus = 1;

        for (int i = length - 1; i >= 0; i--) {
            int digit = digits[i];
            digits[i] = (digit + plus) % 10;
            plus = (digit + plus) / 10;
            if (plus == 0) {
                break;
            }
        }

        //我还得考虑第一位是9然后要进位的情况
        if (plus == 1) {
            int[] result = new int[length + 1];
            int i = 0;
            result[i++] = 1;
            for (int digit : digits) {
                result[i++] = digit;
            }
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 9, 9};
        for (int i : new PlusOne().solution(digits)) {
            System.out.print(i + "  ");
        }
    }
}
