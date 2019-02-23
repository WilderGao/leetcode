package jianzhi;

/**
 * @author WilderGao
 * time 2019-02-13 21:14
 * motto : everything is no in vain
 * description 剑指offer面试题29：顺时针打印矩阵
 */
public class TwentyNine {
    private void printMatrix(int[][] numbers, int columns, int rows) {
        if (numbers == null || columns <= 0 || rows <= 0) {
            return;
        }
        int index = 0;
        while (index <= (columns - 1) / 2 && index <= (rows - 1) / 2) {
            printMatrixEveryCricle(numbers, columns, rows, index);
            index++;
        }
    }

    private void printMatrixEveryCricle(int[][] numbers, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        //首先从左遍历到右
        for (int i = start; i <= endY; i++) {
            printNumber(numbers[start][i]);
        }
        //接着是最右边那一列的遍历，遍历这一行的条件是矩阵至少有两行
        if (start < endX) {
            //也就是起始行和终止行不是同一行
            for (int i = start + 1; i <= endX; i++) {
                printNumber(numbers[i][endY]);
            }
        }

        //接下来遍历最后一行，条件也是矩阵至少有两行,而且至少有两列
        if (start < endX && start < endY) {
            for (int i = endY - 1; i >= 0; i--) {
                printNumber(numbers[endX][i]);
            }
        }
        //最后是遍历最左侧的一列，起码要有三行不然就不需要遍历这一列
        if (start < endX && endX - start > 1){
            for (int i = endX-1; i >= 1; i--) {
                printNumber(numbers[i][start]);
            }
        }
    }

    private void printNumber(int number) {
        System.out.println(number);
    }

    public static void main(String[] args) {
        int[][] numbers = new int[][]{
                {1,2,3},
                {2,3,4},
                {3,4,5}
        };
        int column = numbers.length;
        int rows = numbers[0].length;
        new TwentyNine().printMatrix(numbers, column, rows);
    }

}
