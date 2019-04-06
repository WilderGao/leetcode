package jianzhi;

/**
 * @author wilder
 * @date 19-2-27 下午9:44
 * description 让所有的奇数都排在偶数的前面
 */
public class TwentyOne {
    private int[] recorderOddEven(int[] numbers) {
        if (numbers == null) return null;
        int length = numbers.length;
        int i = 0, j = length - 1;
        while (i < j){
            while (i < j &&(numbers[i] & 1) == 1){
                //代表为奇数
                i++;
                //移动直到它指向偶数
            }
            while (i<j && (numbers[j] & 1) == 0){
                //移动直到他指向奇数
                j--;
            }
            change(numbers, i, j);
        }
        return numbers;
    }

    private void change(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
    }
}
