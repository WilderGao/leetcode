package 数组;

/**
 * @author WilderGao
 * time 2019-10-04 09:15
 * motto : everything is no in vain
 * description leetcode 134:加油站
 */
public class CanCompleteCircuit {

    /**
     * 暴力解法
     *
     * @param gas
     * @param costs
     * @return
     */
    public static int solution(int[] gas, int[] costs) {
        if (gas == null || gas.length == 0) return -1;
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            //找到每一个可以当做起点的位置，然后尝试环绕一圈判断
            if (gas[i] < costs[i]) continue;
            int index = i;
            int gasLeft = gas[i];
            boolean findCircle = true;
            while ((index + 1) % length != i) {
                gasLeft -= costs[index % length];
                gasLeft += gas[(index + 1) % length];
                if (gasLeft < costs[(index + 1) % length]) {
                    //这里证明没有办法绕一圈
                    findCircle = false;
                    break;
                }
                index++;
            }
            if (findCircle) {
                return i;
            }
        }
        return -1;
    }


    public static int solutionSecond(int[] gas, int[] cost) {
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return total < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] costs = new int[]{3, 4, 5, 1, 2};
        System.out.println(solution(gas, costs));
    }
}
