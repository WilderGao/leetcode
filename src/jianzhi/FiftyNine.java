package jianzhi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-02-23 10:03
 * motto : everything is no in vain
 * description 题目一：滑动窗口的最大值
 */
public class EightyNine {
    /**
     * 滑动窗口下最大值
     *
     * @param nums 数组
     * @param size 窗口大小
     * @return 最大值集合
     */
    private List<Integer> maxInWindows(int[] nums, int size) {
        List<Integer> maxInWindows = new ArrayList<>();
        if (nums.length >= size && size >= 1) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                    deque.pollLast();
                }
                deque.add(i);
            }
            //上面就是得到第一个滑动窗口的最大值的下标并将它放入deque双向队列中
            for (int i = size; i < nums.length; i++) {
                maxInWindows.add(nums[deque.getFirst()]);
                while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                    deque.pollLast();
                }
                if (!deque.isEmpty() && deque.getFirst() <= (i - size)) {
                    deque.pollFirst();
                }
                deque.add(i);
            }
            maxInWindows.add(nums[deque.getFirst()]);
        }
        return maxInWindows;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(new EightyNine().maxInWindows(nums, 3));
    }

}
