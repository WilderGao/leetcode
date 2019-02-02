package jianzhi;

/**
 * @author wilder
 * @date 19-1-27 下午7:39
 * description 面试题 4
 */
public class Four {

    /**
     * 判断矩阵中是否包含该数字
     *
     * @param matrix 矩阵
     * @param target 查找的数字
     * @return 是否有找到
     */
    private boolean findInPartiallySortedMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        //思路是每次都从右上角找起，如果比右上角的数字大则去掉对应的行，小则去掉对应的列
        //矩阵的长度
        int weight = matrix.length;
        //矩阵的列数量
        int height = matrix[0].length;
        if (height > 0 && weight > 0) {
            int i = 0, j = height - 1;
            while (i < weight && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (target < matrix[i][j] ) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
        return false;
    }

    //其实同理也可以从左下角开始

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,10,15}
        };
        System.out.println(new Four().findInPartiallySortedMatrix(a, 7));
    }
}
