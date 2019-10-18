package 数组;

/**
 * @author WilderGao
 * time 2019-10-18 10:00
 * motto : everything is no in vain
 * description leetcode 两数之和
 */
public class TwoSum {
    public int[] solution(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        result[0] = i + 1;
        result[1] = j + 1;
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        int[] result = new TwoSum().solution(a, 9);
        System.out.println(result[0] + " " + result[1]);
    }
}
