package 数字;

/**
 * @author WilderGao
 * time 2018-10-23 10:52
 * motto : everything is no in vain
 * description 将整数转换为罗马数字
 * <p>
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表
 *  示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 */
public class IntToRoman {
    public String solution(int num) {
        //我们要注意这个数字的范围在1~3999之间

        char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] value = {1000, 500, 100, 50, 10, 5, 1};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value.length; i += 2) {
            int index = num / value[i];
            num = num % value[i];
            if (index > 0 && index < 4) {
                for (int j = 0; j < index; j++) {
                    result.append(roman[i]);
                }
            } else if (index == 4) {
                result.append(roman[i]).append(roman[i - 1]);
            } else if (index > 4 && index < 9) {
                result.append(roman[i - 1]);
                for (int j = 6; j <= index; j++) {
                    result.append(roman[i]);
                }
            } else if (index == 9) {
                result.append(roman[i]).append(roman[i - 2]);
            }
        }
        return result.toString();
    }

}
