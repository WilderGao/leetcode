package 动态规划;

/**
 * @author WilderGao
 * time 2019-02-03 16:38
 * motto : everything is no in vain
 * description 给你一根长度为n的绳子，请把绳子剪成m段，每段程度的最大乘积是多少
 */
public class MaxProductAfterCutting {
    /**
     * 动态规划的解决方法
     * @param length 绳子原来的长度
     * @return 最大乘积
     */
    private int solutionFirst(int length) {
        //运用动态规划解决问题的话，采用从下到上的方法，将子问题堆积成为所要求的问题
        //当长度为1时最大肯定的1， 长度为2时最大为2，长度为3时最大为3
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i < length + 1; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j]*products[i-j];
                if (product > max){
                    max = product;
                }
            }
            products[i] = max;
        }
        for (int product : products) {
            System.out.print(product+"  ");
        }
        return products[length];
    }

    /**
     * 贪婪算法，下次再写
     * @param length
     * @return
     */
    private int solutionSecond(int length){
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductAfterCutting().solutionFirst(8));
    }
}
