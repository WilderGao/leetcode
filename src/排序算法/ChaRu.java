package 排序算法;

/**
 * @author wilder
 * @date 19-3-28 下午9:46
 * description
 */
public class ChaRu {
    private int[] solution(int[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            int tmp = a[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && a[j - 1] > tmp) {
                    a[j] = a[j - 1];
                } else {
                    a[j] = tmp;
                    break;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 2, 1};
        for (int i : new ChaRu().solution(a)) {
            System.out.print(i);
        }
    }
}
