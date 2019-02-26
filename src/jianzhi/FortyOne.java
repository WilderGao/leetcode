package jianzhi;

import java.util.TreeSet;

/**
 * @author wilder
 * @date 19-2-25 下午6:03
 * description 数据流中的中位数（用堆这一数据结构来解决）
 */
public class FortyOne {
    private TreeSet<Integer> min = new TreeSet<>();
    private TreeSet<Integer> max = new TreeSet<>();
    //把数据分为两部分，左边部分存在大顶堆，右边部分存在小顶堆，保证大顶堆的数都小于小顶堆
    // 那么当个数为奇数时大顶堆的根节点就是中位数，偶数时大顶堆和小顶堆的根节点平均数就是中位数
    private void insert(int num){
        //首先判断奇偶,规定偶数放在小顶堆，奇数放在大顶堆
        if (((min.size() + max.size())&1) == 0){
            //偶数
            //如果出现插入的数字比小顶堆中根节点的数字还要小，则要从大顶堆中找到最大的数放入小顶堆，然后把当前数插入大顶堆
            if (max.size() > 0 && num < max.last()){
                max.add(num);
                //找到大顶堆的根节点
                int maxNum = max.last();
                max.remove(maxNum);
                min.add(maxNum);
            }
            //否则就直接插入大顶堆
            max.add(num);
        }else {
            if (min.size() > 0 && num > min.first()){
                min.add(num);
                //找到小顶堆的根节点
                int minNum = min.first();
                min.remove(minNum);
                max.add(minNum);
            }
            max.add(num);
        }
    }
}
