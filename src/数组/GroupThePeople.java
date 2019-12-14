package 数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WilderGao
 * time 2019-12-14 17:16
 * motto : everything is no in vain
 * description leetcode 1282: 用户分组
 */
public class GroupThePeople {
    private List<List<Integer>> solution(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>(32);
        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                List<List<Integer>> value = map.get(groupSizes[i]);
                List<Integer> lastList = value.get(value.size() - 1);
                if (lastList.size() < groupSizes[i]) {
                    lastList.add(i);
                } else {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(i);
                    value.add(newList);
                }
            } else {
                List<List<Integer>> list = new ArrayList<>();
                List<Integer> listIndex = new ArrayList<>();
                listIndex.add(i);
                list.add(listIndex);
                map.put(groupSizes[i], list);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<List<Integer>>> entry : map.entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> result = new GroupThePeople().solution(groupSizes);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer+"  ");
            }
            System.out.println();
        }
    }
}
