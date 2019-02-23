package jianzhi;

/**
 * @author wilder
 * @date 19-2-23 下午5:14
 * description 字符串空格替换为“%20”
 */
public class Five {
    private char[] replaceBlank(char[] beforeString) {
        int blankCount = 0;
        int stringCount = 0;
        for (char c : beforeString) {
            if (c == ' ') {
                blankCount++;
            } else {
                stringCount++;
            }
        }
        //判断有几个空格然后定义结果字符的长度
        int resultCount = stringCount + 3 * blankCount;
        char[] resultString = new char[resultCount];
        int resultIndex = 0;
        for (char c : beforeString) {
            if (c == ' '){
                resultString[resultIndex++] = '%';
                resultString[resultIndex++] = '2';
                resultString[resultIndex++] = '0';
            }else {
                resultString[resultIndex++] = c;
            }
        }
        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(new Five().replaceBlank("We are coder!".toCharArray()));
    }
}
