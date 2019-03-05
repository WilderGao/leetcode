package 二分查找;

/**
 * @author wilder
 * @date 19-2-10 下午4:14
 * description leetcode 74
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:

输入:
matrix = [
[1,   3,  5,  7],
[10, 11, 16, 20],
[23, 30, 34, 50]
]
target = 3
输出: true
示例 2:

输入:
matrix = [
[1,   3,  5,  7],
[10, 11, 16, 20],
[23, 30, 34, 50]
]
target = 13
输出: false
 */
public class SearchMatrix {
    private boolean solution(int[][] matrix, int target){
        //我们从左下角开始找，如果比左下角大则删除掉对应的这一列，比它小则删除掉对应的这一行
        if (matrix == null){
            return false;
        }
        int xLength = matrix.length;
        if (xLength <= 0){
            return false;
        }
        int yLength = matrix[0].length;
        int x = xLength-1, y = 0;
        while (x >= 0 && y < yLength){
            if (target == matrix[x][y]){
                return true;
            }else if (matrix[x][y] > target){
                x--;
            }else {
                y++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        System.out.println(new SearchMatrix().solution(a, 8));
        System.out.println(new SearchMatrix().solution(a, 3));
    }
}
