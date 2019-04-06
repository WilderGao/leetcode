package 回溯算法;

import java.math.BigInteger;

/**
 * @author WilderGao
 * time 2018-12-10 17:19
 * motto : everything is no in vain
 * description 八皇后问题Java实现
 */
public class EightQueens {
    private static final short NUM = 8 ;
    private static int COUNT = 0;

    public void solution() {
        short[][] chess = new short[NUM][NUM];
        putQueueAtRow(chess, 0);
    }

    private void putQueueAtRow(short[][] chess, int row) {
        if (row == NUM) {
            //说明NUM颗棋子都放到棋盘里面了，成功搞定，终止递归，返回上一层
            ++COUNT;
            System.out.println("第 " + COUNT + " 种解法");
            for (short[] indexChess : chess) {
                for (short i : indexChess) {
                    System.out.print(i + "  ");
                }
                System.out.println();
            }
            return;
        }
        //克隆一个进行回溯算法
        short[][] method = chess.clone();
        //向这一行的每一个位置都尝试摆放皇后
        for (int i = 0; i < NUM; i++) {
            //先将这一行的所有元素先置为0，防止棋盘被污染
            for (int j = 0; j < NUM; j++) {
                method[row][j] = 0;
            }
            method[row][i] = 1;

            if (isSafe(chess, row, i)) {
                putQueueAtRow(method, row+1);
            }
        }
    }

    /**
     * 判断棋子放在这里是否合法
     *
     * @param chess 棋盘
     * @param row   行
     * @param cel   列
     * @return 结果
     */
    private boolean isSafe(short[][] chess, int row, int cel) {
        int step = 1;
        while (step <= row) {
            //判断左上角
            if (cel-step >= 0 && chess[row - step][cel - step] == 1) {
                return false;
            }
            if (chess[row - step][cel] == 1){
                return false;
            }
            if (cel+step <NUM && chess[row - step][cel + step] == 1){
                return false;
            }
            step++;
        }
        return true;
    }

    public static void main(String[] args) {
        new EightQueens().solution();
        System.out.println(0x80000000);
    }
}
