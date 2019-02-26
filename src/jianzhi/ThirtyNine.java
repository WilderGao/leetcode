package jianzhi;

/**
 * @author wilder
 * @date 19-2-23 下午5:41
 * description 数组中出现超过一半的数字
 */
public class ThirtyNine {
    private int moreThanHalfNum(int[] nums) {
        //基于快排的思想，如果那个数超过一半，那么当数组按照快排的思路进行排序之后肯定会出现在中间
        if (nums == null) return -1;
        int length = nums.length;
        int middle = length >> 1;
        int start = 0, end = length - 1;
        int index = partition(nums, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        int result = nums[middle];
        if (checkMoreThanHalf(nums, result)) {
            return result;
        }
        return -1;
    }

    private int partition(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            while (start < end && nums[end] > tmp) {
                end--;
            }
            //这个时候end指向的值比tmp要小，要把值赋给start指向的指针，然后start++
            if (start < end) {
                nums[start] = nums[end];
                start++;
            }
            while (start < end && nums[start] <= tmp) {
                start++;
            }
            if (start < end) {
                nums[end] = nums[start];
                end--;
            }
        }
        nums[start] = tmp;
        return start;
    }

    private boolean checkMoreThanHalf(int[] nums, int num) {
        int numCount = 0;
        int length = nums.length;
        for (int i : nums) {
            if (i == num) numCount++;
        }
        return numCount * 2 >= length;
    }


    private int moreThanHalfNumTwo(int[] nums) {
        //超过一般那么那个数的数量肯定比其他书加起来还要多
        if (nums == null) return -1;
        int result = nums[0];
        int times = 1;
        for (int num : nums) {
            if (times == 0) {
                result = num;
                times = 1;
            } else if (num == result) {
                times++;
            } else {
                times--;
            }
        }
        if (checkMoreThanHalf(nums, result)){
            return result;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 3, 5, 6, 3, 3, 3};
        System.out.println(new ThirtyNine().moreThanHalfNumTwo(a));
    }
}
