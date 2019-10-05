package 数组;

import java.util.HashSet;
import java.util.Set;

/**
 * @author WilderGao
 * time 2019-10-03 20:33
 * motto : everything is no in vain
 * description
 */
public class LongestConsecutive {

    /**
     * 这是我自己想的方法，发现会超出Integer的范围，不可取
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int[] resultArray = new int[max - min + 1];
        for (int num : nums) {
            resultArray[num - min]++;
        }
        int tmpResult = 0;
        int finalResult = 0;
        for (int i : resultArray) {
            if (i == 0) {
                finalResult = Math.max(finalResult, tmpResult);
                tmpResult = 0;
            } else {
                tmpResult++;
            }
        }
        return finalResult + tmpResult;
    }


    private static int solutionSecond(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num)) {
                int left = num - 1;
                int right = num + 1;
                while (set.remove(left)) {
                    left--;
                }
                while (set.remove(right)) {
                    right++;
                }
                res = Math.max(res, right - left - 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = new int[]{0, -1};
        System.out.println(solutionSecond(a));
    }
}
