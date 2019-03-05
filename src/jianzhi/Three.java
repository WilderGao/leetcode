package jianzhi;

/**
 * @author wilder
 * @date 19-2-23 下午3:52
 * description 寻找数组中重复的数字,长度为n里面的数字范围为1～n-1
 */
public class Three {

    /**
     * 改变数组元素的做法
     *
     * @param nums 数组
     * @return 重复的第一个数字
     */
    private int getDuplicateChangeArray(int[] nums) {
        if (nums == null) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                //如果nums[i]上的数不是i，就和i上的数进行比较
                if (nums[nums[i]] == nums[i]) {
                    //如果这两个数相等就代表此时有重复的数
                    return nums[i];
                }
                //交换这两个数
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    private int getDuplicateNoChangeArray(int[] nums) {
        //通过二分法的思想，如果1～m的数字超过m那么就代表重复的数字在这里
        if (nums == null) return -1;
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            int middle = (start + end) >> 1;
            int count = countRange(nums, start, middle);
            if (count > (middle - start + 1)){
                end = middle;
            }else {
                start = middle + 1;
            }
        }
        return start;
    }

    private int countRange(int[] nums, int start, int end) {
        int count = 0;
        for (int num : nums) {
            if (num >= start && num <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(new Three().getDuplicateChangeArray(nums));
        System.out.println(new Three().getDuplicateNoChangeArray(nums));
    }
}
