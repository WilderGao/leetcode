package 排序算法;

/**
 * @author wilder
 * @date 19-3-28 下午9:46
 * description
 */
public class ChaRu {
    private int[] solution(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int index = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (index < a[j]) {
                    a[j + 1] = a[j];
                    a[j] = index;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 2, 1};
        for (int index : new ChaRu().solution(a)) {
            System.out.print(index + " ");
        }
    }
}
