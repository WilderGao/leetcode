package 排序算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author WilderGao
 * time 2018-10-10 21:00
 * motto : everything is no in vain
 * description
 * 给定一个未排序的数列，找到此数列在已排序状态下的两个相邻值的最大差值，少于两个值时返回0。
 * 例如：给定数列 [1,3,2,0,1,6,8] 则 最大差值为3。注意：请尽量使用时间复杂度为O(n)的方案。
 */
public class MaximumGap {
    /**
     * 1.利用桶排序的思想，先求出原数组从最小值Min到最大值Max的单位区间长度d，d=(Max-Min)/n。算出d的作用是为了后续确定各个桶的区间范围划分。
     * 2.创建一个长度是N+1的数组Array，数组的每一个元素都是一个List，代表一个桶。
     * 3.遍历原数组，把原数组每一个元素插入到新数组Array对应的桶当中，进入各个桶的条件是根据不同的数值区间。由于桶的总数量是N+1，所以至少有一个桶是空的。
     * 4.遍历新数组Array，计算每一个空桶右端非空桶中的最小值，与空桶左端非空桶的最大值的差，数值最大的差即为原数组排序后的相邻最大差值。
     * @param nums 起始数组
     * @return
     */
    public int solution(int[] nums){
        if (nums == null || nums.length<2){
            return 0;
        }
        int[] resultArray = bullSort(nums);
        int maximumGap = 0;
        for (int i = 0; i < resultArray.length-1; i++) {
            maximumGap = Math.max(resultArray[i+1] - resultArray[i], maximumGap);
        }

        return maximumGap;
    }

    private int[] bullSort(int[] nums){
        int max = nums[0];
        int min = nums[0];
        int index = 0;
        int length = nums.length;
        //得到最大值和最小值
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int interval = (max - min) / (length-1) +1;
        List<Integer>[] resultList = new ArrayList[((max - min)/interval)+1];
        for (int num : nums) {
            index = (num-min)/interval;
            if (resultList[index] == null){
                resultList[index] = new ArrayList();
            }
            resultList[(num-min)/interval].add(num);
        }

        for (List list : resultList) {
            if (list != null) {
                Collections.sort(list);
            }
        }
        int[] result = new int[length];
        int k = 0;
        for (int i = 0; i < resultList.length; i++) {
            if (resultList[i] != null){
                for (int j = 0; j < resultList[i].size(); j++) {
                    result[k ++] = resultList[i].get(j);
                }
            }
        }
        return result;
    }

}
