package 排序算法;

/**
 * @author wilder
 * @date 19-3-28 下午9:37
 * description 选择排序
 */
public class XuanZe {
    private int[] solution(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i+1; j < length; j++) {
                if (a[min] > a[j]){
                    min = j;
                }
            }
            int tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 2, 1};
        for (int index : new XuanZe().solution(a)) {
            System.out.print(index + " ");
        }
    }
}
