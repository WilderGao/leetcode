package 动态规划;

/**
 * @author WilderGao
 * time 2019-02-17 17:49
 * motto : everything is no in vain
 * description leetcode 91 解码方法，动态规划思想，由上到下的做法可以避免重复值的计算
 */
public class NumDecodings {
    private int solution(String s) {
        if (s == null) return 0;
        int length = s.length();
        int count;
        int[] counts = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            count = 0;
            if (i < length - 1) {
                if(s.charAt(i)!='0') {
                    count = counts[i + 1];
                }
            } else {
                //只有一个数字的时候肯定就有一种解码方法,如果是0的话就没有解法
                if(s.charAt(i) != '0'){
                    count = 1;
                }
            }
            if (i < length - 1) {
                int currentNum = s.charAt(i) - 48;
                int lastNum = s.charAt(i + 1) - 48;
                int addNum = currentNum * 10 + lastNum;
                if (addNum >= 10 && addNum <= 26) {
                    //根据动态规划
                    if (i < length - 2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }
            counts[i] = count;
        }
        return counts[0];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().solution("10"));
    }
}
