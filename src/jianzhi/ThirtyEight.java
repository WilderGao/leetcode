package jianzhi;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wilder
 * @date 19-2-26 下午7:44
 * description 字符串的全排列
 */
public class ThirtyEight {
    private List<String> permutation(char[] str) {
        if (str == null) return null;
        List<String> result = new LinkedList<>();
        help(str, 0, result);
        return result;
    }

    private void help(char[] str, int index, List<String> result) {
        if (index == str.length) {
            String resultIndex = new String(str);
            result.add(resultIndex);
        } else {
            for (int i = index; i < str.length; i++) {
                char tmp = str[index];
                str[index] = str[i];
                str[i] = tmp;
                help(str, index + 1, result);

                //弄完搞回来
                tmp = str[i];
                str[i] = str[index];
                str[index] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        char[] str = new char[]{'a', 'b', 'c','d'};
        System.out.println(new ThirtyEight().permutation(str));
    }
}