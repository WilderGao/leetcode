package 数组;

/**
 * @author WilderGao
 * time 2019-10-27 14:10
 * motto : everything is no in vain
 * description leetcode 1013： 将数组分成和相等的三个部分
 */
public class CanThreePartsEqualSum {
    public boolean solution(int[] a) {
        if (a == null || a.length == 0) {
            return true;
        }
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int sumPartThree = sum / 3;
        int tmpSum = 0;
        int index = 0;
        for (int i : a) {
            tmpSum += i;
            if (tmpSum == sumPartThree) {
                tmpSum = 0;
                index++;
            }
        }
        return tmpSum == 0 && index == 3;
    }

    public static void main(String[] args) {
        int[] a = new int[]{12, -4, 16, -5, 9, -3, 3, 8, 0};
        System.out.println(new CanThreePartsEqualSum().solution(a));
    }
}
