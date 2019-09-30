import java.util.ArrayList;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-09-27 15:13
 * motto : everything is no in vain
 * description
 */
public class Pailie {
    private static void help(char[] chars, List<String> result, int start, int length) {
        if (start == length - 1) {
            result.add(new String(chars));
            return;
        }
        for (int i = start; i < length; i++) {
            swap(chars, start, i);
            help(chars, result, start + 1, length);
            swap(chars, start, i);
        }
    }

    private static void swap(char[] chars, int x, int y) {
        char tmp = chars[x];
        chars[x] = chars[y];
        chars[y] = tmp;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'c', 'd'};
        List<String> result = new ArrayList<>();
        help(chars, result, 0, chars.length);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
