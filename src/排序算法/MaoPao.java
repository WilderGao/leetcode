package 排序算法;

/**
 * @author wilder
 * @date 19-3-28 下午9:33
 * description 冒泡排序
 */
public class MaoPao {
    private int[] solution(int[] a) {
        int length = a.length;
        for (int i = 0; i<length;i++){
            for (int j = 0;j<length - i-1;j++){
                if (a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
        return a;
    }
}
