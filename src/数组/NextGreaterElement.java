package 数组;

import java.util.*;

/**
 * @author WilderGao
 * time 2019-10-23 19:41
 * motto : everything is no in vain
 * description leetcode: 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 */
public class NextGreaterElement {
    public int[] solution(int[] num1, int[] num2) {
        Map<Integer, List<Integer>> map = new HashMap<>(64);
        for (int i = 0; i < num2.length; i++) {
            if (map.containsKey(num2[i])) {
                map.get(num2[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num2[i], list);
            }
        }
        int[] result = new int[num1.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < num1.length; i++) {
            if (!map.containsKey(num1[i])) {
                result[i] = -1;
            } else {
                int index = map.get(num1[i]).get(0);
                for (int j = index; j < num2.length; j++) {
                    if (num2[j] > num1[i]) {
                        result[i] = num2[j];
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{4, 1, 2};
        int[] num2 = new int[]{1, 3, 4, 2};
        for (int i : new NextGreaterElement().solution(num1, num2)) {
            System.out.print(i + " ");
        }
    }
}
