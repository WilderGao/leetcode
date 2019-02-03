package 动态规划;

/**
 * @author WilderGao
 * time 2019-02-03 16:38
 * motto : everything is no in vain
 * description 给你一根长度为n的绳子，请把绳子剪成m段(m>1 && n>1)，每段程度的最大乘积是多少
 */
public class MaxProductAfterCutting {
    /**
     * 动态规划的解决方法
     *
     * @param length 绳子原来的长度
     * @return 最大乘积
     */
    private int solutionFirst(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        //运用动态规划解决问题的话，采用从下到上的方法，将子问题堆积成为所要求的问题
        //当长度为1时最大肯定的1， 长度为2时最大为2，长度为3时最大为3
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i < length + 1; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (product > max) {
                    max = product;
                }
            }
            products[i] = max;
        }
        return products[length];
    }

    /**
     * 贪婪算法，有一个原理就是把绳子分成长度为3的时候乘积是最长的，所以把长度按照3为单位进行切割，切割到最后长度为4的时候就不要进行3、1切分，而是进行2、2切分
     *
     * @param length 绳子原来的长度
     * @return 最大乘积
     */
    private int solutionSecond(int length) {
        int timeOfThree = length / 3;
        if (length - timeOfThree * 3 == 1) {
            //说明最后的长度为4
            timeOfThree--;
        }
        int timeOfTwo = (length - timeOfThree * 3) / 2;
        int result = (int) (Math.pow(3, timeOfThree) * Math.pow(2, timeOfTwo));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductAfterCutting().solutionFirst(8));
        System.out.println(new MaxProductAfterCutting().solutionSecond(8));
    }
}
