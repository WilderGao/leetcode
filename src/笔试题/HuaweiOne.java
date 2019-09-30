package 笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author WilderGao
 * time 2019-09-18 19:26
 * motto : everything is no in vain
 * description
 */
public class HuaweiOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> statement = new ArrayList<>();
        List<Boolean> result = new ArrayList<>();
        String line;
        while (!(line = in.nextLine()).equals("")) {
            statement.add(line);
        }
        for (String s : statement) {
            String[] items = s.split(" ");
            result.add(isHeFa(items));
        }
        for (Boolean aBoolean : result) {
            System.out.print(aBoolean + " ");
        }
    }

    private static boolean isHeFa(String[] items) {
        if (items == null) return false;
        boolean result = true;
        int first = Integer.parseInt(items[0]);
        int last = Integer.parseInt(items[items.length - 1]);
        if (first >= 10 && first < 100 && last >= 10 && last < 100) {
            for (int i = 1; i < items.length - 1; i++) {
                if (Integer.parseInt(items[i]) >= 10 && Integer.parseInt(items[i]) < 100) {
                    result = false;
                    break;
                }
            }
        }
        if (first >= 0 && first < 10 && last >= 0 && last < 10) {
            for (int i = 1; i < items.length - 1; i++) {
                if (Integer.parseInt(items[i]) >= 0 && Integer.parseInt(items[i]) < 10) {
                    result = false;
                    break;
                }
            }
        }
        if (result) return true;
        int check = Integer.parseInt(items[0]) > 10 ? 1 : 0;
        for (int i = 1; i < items.length; i++) {
            if (Integer.parseInt(items[i]) % 10 > 0 && check == 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
