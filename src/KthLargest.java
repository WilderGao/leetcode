import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author WilderGao
 * time 2019-10-23 15:19
 * motto : everything is no in vain
 * description leetcode : 设计一个找到数据流中第K大元素的类（class）
 */
public class KthLargest {
    private List<Integer> list = new ArrayList<>();
    private int k;
    private int size = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            list.add(num);
        }
        size = nums.length;
    }

    public int add(int val) {
        list.add(val);
        size++;
        Collections.sort(list);
        return list.get(size - k);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3));
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
    }
}
