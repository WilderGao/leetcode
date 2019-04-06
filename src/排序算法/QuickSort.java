package 排序算法;

/**
 * @author WilderGao
 * time 2019-04-06 17:13
 * motto : everything is no in vain
 * description 快速排序算法
 */
public class QuickSort {
    private int partition(int[] a, int start, int end) {
        int pos = a[start];
        int i = start, j = end;
        while (i < j) {
            while (i<j && a[j]>pos){
                j--;
            }
            if (i < j && a[j] <= pos){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
            while (i<j && a[i] <= pos) {
                i++;
            }
            if (i < j && a[i] > pos) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                j--;
            }
        }
        a[j] = pos;
        return j;
    }

    private void sort(int[] a, int start, int end){
        if (start >= end) return;
        int middle = partition(a, start, end);
        sort(a, start, middle);
        sort(a, middle+1, end);
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,7,6,5,3,2,1};
        new QuickSort().sort(a, 0, a.length-1);
        for (int index : a) {
            System.out.print(index+" ");
        }
    }
}
