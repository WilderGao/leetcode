/**
 * @author WilderGao
 * time 2018-10-09 13:52
 * motto : everything is no in vain
 * description  找出缺失的整数
 */
public class MissingNumber {
    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数
     * @param nums
     * 用0~n所有整数的和减去数组中所有整数的和，得到的就是缺失的那个整数
     * @return
     */
    public int solutionFirst(int[] nums){
        int max = nums.length;
        int sum = 0;
        //找到最大的数字
        for (int num : nums) {
            sum += num;
        }
        int total = 0;
        for (int i = 0;i<= max; i++){
            total += i;
        }
        return total-sum;
    }

    /**
     * 一个无序数组里有若干个正整数，范围从1到100，其中99个整数都出现了偶数次，只有一个整数出现了奇数次（比如1,1,2,2,3,3,4,5,5），如何找到这个出现奇数次的整数？
     * @param nums
     * 通过数组内所有数字进行异或处理，如果偶数的话异或结果会是0，所以不是偶数个的那个数异或结果不是0
     * @return
     */
    public int solutionSecond(int[] nums){
        int num = 0;
        for (int i =0; i<nums.length; i++){
            num = num ^ nums[i];
        }
        return num;
    }

    /**
     * 一个无序数组里有若干个正整数，范围从1到100，其中98个整数都出现了偶数次，只有两个整数出现了奇数次（比如1,1,2,2,3,4,5,5），如何找到这个出现奇数次的整数？
     * @param nums
     * @return
     */
    public int[] solutionThird(int[] nums){
        int resultA = 0;
        int resultB = 0;
        //得到两个奇数次整数的异或结果
        int num = solutionSecond(nums);
        //分治法，通过这个结果获得分水岭
        int numShift = getShedNum(num);
        for (int i : nums) {
            resultA = (i & numShift) != 0? (resultA ^ i):resultA;
            resultB = (i & numShift) == 0? (resultB ^i) : resultB;
        }
        return new int[]{resultA, resultB};
    }

    /**
     * 得到那个分水岭的数
     * @param num 异或结果
     * @return
     */
    private int getShedNum(int num){
        int numShift = 1;
        while ((num & numShift) == 0){
            numShift = numShift << 1;
        }
        return numShift;
    }

}
