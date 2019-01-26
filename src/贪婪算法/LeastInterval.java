package 贪婪算法;

import java.util.Arrays;

/**
 * @author wilder
 * @date 19-1-26 下午12:04
 * description leetcode 621
 * <p>
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * <p>
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 * 示例 1：
 * <p>
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 */
public class LeastInterval {
    /**
     * 这里刚开始可能有点难理解，其实就是说执行两个A任务之间需要间隔n个单位的时间（这里的n是2）
     * 所以在两个A之间需要间隔，这之间可以插入一个B，但是还有一个间隔搞不了所以就是待命
     */
    private int solution(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        } else {
            //首先要找到次数最多的那个任务
            //定义一个26（26个字母）的集合来存储每个字母出现的次数,题目范围是A-Z
            int[] taskCollect = new int[26];
            for (char task : tasks) {
                ++taskCollect[task - 'A'];
            }
            Arrays.sort(taskCollect);
            //然后对集合进行排序，这样子的话次数最多的肯定就是第26个
            int timesMax = taskCollect[25];
            //根据大佬的思路，解法就是找出次数最多的先来进行分组，可以看到分组的数量等于任务出现最多的任务的次数-1，从tasks看A出现次数最多，
            //为3次，所以分成两组，一组的长度为n+1，也就是A--三个单位长度，最后再加上出现次数最多的组合，这里AB同时出现最多，所以再加上2
            int lastPlus = 25;
            while (lastPlus > 0 && taskCollect[lastPlus] == timesMax) {
                lastPlus--;
            }
            //为什么要和tasks的长度进行比较呢，因为存在这样的一种情况
            // {'A','A','A','B','B','B'} n为0，这个时候分段n+1为1，但是AB的话长度为2，所以这种方式有可能有错误，所以最短就是整个任务的长度了
            return Math.max((timesMax - 1) * (n + 1) + (25 - lastPlus), tasks.length);
        }
    }

    public static void main(String[] args) {
        char[] a = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(new LeastInterval().solution(a, 2));
    }


}
