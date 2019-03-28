package 排序算法;

/**
 * @author wilder
 * @date 19-3-28 下午9:37
 * description 选择排序
 */
public class XuanZe {
    private int[] solution(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int flag = 0;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        return a;
    }
}
