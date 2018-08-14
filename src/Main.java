import java.io.IOException;
import java.util.HashMap;

public class Main {
    private int i;

    public int reverse(int x) {
        int finalNum = 0;
        int tmp;
        while (x != 0) {
            tmp = x % 10;
            x /= 10;
            if (finalNum > Integer.MAX_VALUE / 10 || finalNum == Integer.MAX_VALUE / 10 && tmp > 7) {
                return 0;
            }
            if (finalNum < Integer.MIN_VALUE / 10 || finalNum == Integer.MIN_VALUE / 10 && tmp < -8) {
                return 0;
            }
            finalNum = finalNum * 10 + tmp;
        }
        return finalNum;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            Integer num = x;
            char[] charAt = num.toString().toCharArray();
            int length = charAt.length;
            for (int i = 0; i <= length / 2; i++) {
                if (charAt[i] != charAt[length - i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Main().isPalindrome(1234321));
    }
}
