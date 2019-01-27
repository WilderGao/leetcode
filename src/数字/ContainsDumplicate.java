package 数字;

/**
 * @author wilder
 * @date 19-1-27 下午6:04
 * description 找出重复的元素，数组长度为n，里面的数为0～n-1
 * 判断是否存在重复元素
 * 同时也是剑指 offer 的面试题2
 */
public class ContainsDumplicate {
    private boolean solution(int[] numbers){
        int length = numbers.length;
        if (length <= 1) return false;
        int tmp ;
        //长度为n的数组中的数字为0～n-1,那么如果按照顺序排列的话应该是下标对应着对应的数字
        //如果下标i和num[i]不相等，那么再比较num[num[i]]的数字和num[i]的数字是否相等，如果相等就代表是有重复的，如果没有则将num[i]去到他该去的地方
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    return true;
                }else {
                    //不相等则交换数字，让数字去到它该去的位置
                    tmp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = tmp;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1};
        System.out.println(new ContainsDumplicate().solution(a));
    }
}
