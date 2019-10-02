package 字符串;

import java.util.*;

/**
 * @author WilderGao
 * time 2019-09-30 15:29
 * motto : everything is no in vain
 * description
 */
public class GroupAnagrams {
    private static List<List<String>> solution(String[] sts) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String s : sts) {
            char[] indexChar = s.toCharArray();
            Arrays.sort(indexChar);
            String index = new String(indexChar);
            if (!map.containsKey(index)){
                List<String> list = new LinkedList<>();
                list.add(s);
                map.put(index, list);
            }else {
                map.get(index).add(s);
            }
        }

        map.forEach((k,v)->result.add(v));
        return result;
    }

    public static void main(String[] args) {
        String[] sts = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        for (List<String> list : solution(sts)) {
            System.out.println(list);
        }
    }
}
