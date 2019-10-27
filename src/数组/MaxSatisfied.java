package 数组;

/**
 * @author WilderGao
 * time 2019-10-26 10:30
 * motto : everything is no in vain
 * description leetcode leetcode 1052: 爱生气的书店老板
 */
public class MaxSatisfied {

    /**
     * 利用滑动窗口来解决，多用一些变量保留中间值，减少for次数
     *
     * @param customers
     * @param grumpy
     * @param x
     * @return
     */
    public int solution(int[] customers, int[] grumpy, int x) {
        if (customers == null || grumpy == null || customers.length != grumpy.length) {
            return 0;
        }
        int max = 0;
        if (x >= customers.length) {
            for (int customer : customers) {
                max += customer;
            }
            return max;
        }

        //保留所有当前不生气的
        int availableAll = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                availableAll += customers[i];
            }
        }
        //第一轮的情况
        int windowsValue = 0;
        int windowsAvailValue = 0;
        for (int i = 0; i < x; i++) {
            windowsValue += customers[i];
            if (grumpy[i] == 0) {
                windowsAvailValue += customers[i];
            }
        }
        max = Math.max(windowsValue + availableAll - windowsAvailValue, max);

        int length = customers.length;
        for (int i = 1; i <= length - x; i++) {
            windowsValue -= customers[i - 1];
            windowsValue += customers[i + x - 1];
            if (grumpy[i - 1] == 0) {
                windowsAvailValue -= customers[i - 1];
            }
            if (grumpy[i + x - 1] == 0) {
                windowsAvailValue += customers[i + x - 1];
            }
            max = Math.max(max, windowsValue + availableAll - windowsAvailValue);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]   {0, 1, 0, 1, 0, 1, 0, 1};
        int x = 3;
        System.out.println(new MaxSatisfied().solution(customers, grumpy, x));
    }
}
