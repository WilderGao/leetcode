package 数组;

/**
 * @author WilderGao
 * time 2019-10-05 21:34
 * motto : everything is no in vain
 * description leetcode 11: 盛最多水的容器
 */
public class MaxArea {
    public static int solution(int[] height) {
        if (height == null || height.length == 0) return 0;
        int i = 0, j = height.length - 1;
        int result = 0;
        while (i < j) {
            result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
