package 数组;

/**
 * @author WilderGao
 * time 2019-10-18 09:46
 * motto : everything is no in vain
 * description 偶数放在奇数前面（用快排解决）
 */
public class SortArrayByParity {
    public int[] solution(int[] array) {
        if (array == null || array.length == 0) return array;
        int length = array.length;
        int i = 0, j = length - 1;
        while (i < j) {
            while (i < j && array[j] % 2 == 1) {
                j--;
            }
            if (i < j) {
                swap(array, i++, j);
            }
            while (i < j && array[i] % 2 == 0) {
                i++;
            }
            if (i < j) {
                swap(array, i, j--);
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1};
        new SortArrayByParity().solution(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
