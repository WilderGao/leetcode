package 动态规划;

/**
 * @author WilderGao
 * time 2018-10-21 22:42
 * motto : everything is no in vain
 * description  Given n items with size Ai and value Vi, and a backpack with size m.
 * What's the maximum value can you put into the backpack?
 */
public class MaxValue {

    /**
     * 常规的动态规划建立二维表的解决方法
     * @param weight    物品重量集合
     * @param value     物品价值集合
     * @param packageWeight     背包重量
     * @return      返回最大价值
     */
    public int solution(int[] weight, int[] value, int packageWeight) {
        int size = weight.length;
        int[][] result = new int[packageWeight+1][size];
        for (int i = 0; i <= packageWeight; i++) {
            if (weight[0] > i){
                //只有第一件物品，而且这件物品的重量还比背包的重量大，所以价值为0
                result[i][0] = 0;
            }else {
                result[i][0] = value[0];
            }
        }
        //当背包承受总量为0的时候当然全都为0
        for (int j = 0; j < size; j++) {
            result[0][j] = 0;
        }

        for (int i = 1; i <= packageWeight; i++) {
            for (int j = 1; j < size; j++) {
                //此时背包的重量为i，有j个物品
                if (i<weight[j]) {
                    result[i][j] = result[i][j - 1];
                }else {
                    if (result[i-weight[j]][j-1]+value[j] > result[i][j-1]){
                        result[i][j] = result[i-weight[j]][j-1]+value[j];
                    }else {
                        result[i][j] = result[i][j-1];
                    }
                }
            }
        }
        return result[packageWeight][size-1];
    }

    public static void main(String[] args) {
        int[] weight = {2,2,6,5,4};
        int[] value = {6,3,5,4,6};
        int packageWeight = 10;
        System.out.println(new MaxValue().solution(weight, value, packageWeight));
    }
}
