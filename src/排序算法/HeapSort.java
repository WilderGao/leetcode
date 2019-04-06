package 排序算法;

/**
 * @author WilderGao
 * time 2019-04-06 17:39
 * motto : everything is no in vain
 * description 堆排序实现
 */
public class HeapSort {
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void sort(int[] arr){
        //构建大顶堆
        for (int i = arr.length/2-1;i>=0;i--){
            adjustHeap(arr, i, arr.length);
        }
        //调整堆结构
        for (int i = arr.length - 1; i > 0;i--){
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,7,6,5,3,2,1};
        sort(a);
        for (int index : a) {
            System.out.print(index+" ");
        }
    }
}
