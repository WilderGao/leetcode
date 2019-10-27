import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WilderGao
 * time 2019-10-26 21:22
 * motto : everything is no in vain
 * description leetcode 398: 随机数索引
 */
public class Solution {
    private Map<Integer, List<Integer>> valueMap = new HashMap<>(16);
    private Map<Integer, Node> positionMap = new HashMap<>(16);

    /**
     * 后面得研究一下蓄水抽样法
     * @param nums
     */
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (valueMap.containsKey(nums[i])) {
                valueMap.get(nums[i]).add(i);
            } else {
                List<Integer> indexs = new ArrayList<>();
                indexs.add(i);
                valueMap.put(nums[i], indexs);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : valueMap.entrySet()) {
            Node node = new Node(0, entry.getValue().size());
            positionMap.put(entry.getKey(), node);
        }
    }

    public int pick(int target) {
        Node node = positionMap.get(target);
        //找到结果并指向下一个
        int index = node.index;
        node.index = (node.index + 1) % node.size;
        return valueMap.get(target).get(index);
    }

    class Node {
        int index;
        int size;

        public Node(int index, int size) {
            this.index = index;
            this.size = size;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution solution = new Solution(nums);
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
    }
}
