package 排序算法;

/**
 * @author wilder
 * @date 19-3-28 下午10:07
 * description 归并排序
 */
public class GuiBing {
    private int[] solution(int[] a) {
        int length = a.length;
        int[] tmp = new int[length];
        sort(a, 0, length-1, tmp);
        return a;
    }

    private void sort(int[] a, int left, int right, int[] tmp) {
        if (left < right) {
            //还没有归并到最后一个
            int middle = (left + right) / 2;
            sort(a, left, middle, tmp);
            sort(a, middle+1, right, tmp);
            merge(a, left, middle, right, tmp);
        }
    }

    private void merge(int[] a, int left, int mid, int right, int[] tmp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i<=mid && j<=right){
            if (a[i] < a[j]){
                tmp[t++] = a[i++];
            }else {
                tmp[t++] = a[j++];
            }
        }
        while (i<=mid){
            tmp[t++] = a[i++];
        }
        while (j<=right){
            tmp[t++] = a[j++];
        }
        t = 0;
        //数组拷贝
        while (left<=right){
            a[left++] = tmp[t++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,2,1,6};
        for (int i : new GuiBing().solution(a)) {
            System.out.print(i);
        }
    }
}
