package jianzhi;

/**
 * @author WilderGao
 * time 2019-04-13 10:41
 * motto : everything is no in vain
 * description 打印1到最大的n位数
 */
public class Seventeen {
    private void print1ToMaxOfNDigits(int n) {
        if (n <= 0) return;
        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }
        while (!increment(number)) {
            printNumber(number);
        }

    }

    private boolean increment(char[] number) {
        boolean isOverFlow = false;
        //进位符
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                //如果不是第一位就进位，否则结束
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverFlow;
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (number[index] == '0'){
            index++;
        }
        for (int i = index; i < number.length; i++) {
            System.out.print(number[i]);
        }
        System.out.print("\t");
    }

    public static void main(String[] args) {
        new Seventeen().print1ToMaxOfNDigits(3);
    }
}
