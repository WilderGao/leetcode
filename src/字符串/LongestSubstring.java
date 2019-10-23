package 字符串;

/**
 * @author WilderGao
 * time 2019-10-22 15:16
 * motto : everything is no in vain
 * description leetcode 395: 至少有K个重复字符的最长子串
 */
public class LongestSubstring {

    /**
     * 思路：弄两个指针分别指向字符串的头和尾，统计两个指针包括的长度里面每个元素出现的次数，然后向内收缩，发现没有到达k次的就进行划分
     * 例子：  abaadbbc k=2
     * 统计后  a:3, b:3, c:1, d:1
     * 两个指针分别是 left = 0, right = length-1
     * right指向的c只出现了一次小于k，所以往前移动 right = length-2；
     * 然后从left往right方向遍历，遍历到d小于1，所以进行拆分，递归操作，拆分成 abaa 和 bbc两个
     * 下一层 abaa又拆为 a 和 aa， bbc的结果为2
     * 所以最后的结果为 2
     *
     * @param s
     * @param k
     * @return
     */
    public int solution(String s, int k) {
        if (s == null || s.length() == 0 || k > s.length()) {
            return 0;
        }
        if (k < 2) {
            return s.length();
        }
        return count(s.toCharArray(), k, 0, s.length() - 1);
    }

    private int count(char[] chars, int k, int left, int right) {
        if (right - left + 1 < k) {
            return 0;
        }
        int[] times = new int[26];
        for (int i = left; i <= right; i++) {
            ++times[chars[i] - 'a'];
        }
        while (right - left + 1 >= k && times[chars[left] - 'a'] < k) {
            left++;
        }
        while (right - left + 1 >= k && times[chars[right] - 'a'] < k) {
            right--;
        }
        if (right - left + 1 < k) {
            return 0;
        }
        for (int i = left; i <= right; i++) {
            if (times[chars[i] - 'a'] < k) {
                return Math.max(count(chars, k, left, i - 1), count(chars, k, i + 1, right));
            }
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().solution("abaadbbc", 2));
    }
}
