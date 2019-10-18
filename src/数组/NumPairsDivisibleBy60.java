package 数组;

/**
 * @author WilderGao
 * time 2019-10-18 19:49
 * motto : everything is no in vain
 * description
 */
public class NumPairsDivisibleBy60 {

    /**
     * 最垃圾的O(n^2)复杂度
     *
     * @param time
     * @return
     */
    public int solution(int[] time) {
        int result = 0;
        if (time == null || time.length == 0) {
            return result;
        }
        int length = time.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 看到另一种很6的方法，别人还是厉害啊
     *
     * @param time
     * @return
     */
    public int solutionTwo(int[] time) {
        int result = 0;
        if (time == null || time.length == 0) {
            return result;
        }
        int[] array = new int[60];
        for (int t : time) {
            //求余数，然后查看和他互补的有几个
            t %= 60;
            int index = t == 0 ? 0 : 60 - t;
            result += array[index];
            array[t]++;
        }
        return result;
    }
}
