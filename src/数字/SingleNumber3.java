package 数字;

/**
 * @author wilder
 * @date 19-3-2 下午2:46
 * description leetcode 260
 */
public class SingleNumber3 {
    private int[] solution(int[] nums) {
        int twoAdd = 0;
        for (int num : nums) {
            twoAdd ^= num;
        }
        int diff = 1;
        while ((diff & twoAdd) == 0) {
            diff = diff << 1;
        }
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 1, 3, 2, 5};
        int[] b = new SingleNumber3().solution(a);
        System.out.println(b[0] + " " + b[1]);
    }
}
