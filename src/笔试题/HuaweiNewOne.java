package 笔试题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author WilderGao
 * time 2019-10-16 19:05
 * motto : everything is no in vain
 * description
 */
public class HuaweiNewOne {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>(16);
        map.put('0', 1);
        map.put('4', 1);
        map.put('6', 1);
        map.put('8', 2);
        map.put('9', 1);

        map.put('a', 1);
        map.put('b', 1);
        map.put('d', 1);
        map.put('e', 1);

        map.put('A', 1);
        map.put('B', 2);
        map.put('D', 1);

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line == null || line.length() == 0) {
            System.out.println(0);
            return;
        }
        int num = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (map.containsKey(c)) {
                num += map.get(c);
            }
        }
        System.out.println(num);
    }
}
