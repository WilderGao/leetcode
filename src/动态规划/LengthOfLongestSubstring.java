package 动态规划;

/**
 * @author WilderGao
 * time 2019-02-18 15:19
 * motto : everything is no in vain
 * description leetcode 3
 */
public class LengthOfLongestSubstring {
    private static int solution(String s) {
        int maxLength = 0;
        int currentLength = 0;
        int[] positions = new int[256];
        for (int i = 0; i < positions.length; i++) {
            //初始化为-1表示前面没有出现过这个字符
            positions[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            int preIndex = positions[index];
            if (preIndex == -1 || i - preIndex > currentLength) {
                //如果之前没有出现或者说之前出现的位置与当前位置的距离比当前最长的长度还长
                ++currentLength;
            }else {
                if (currentLength > maxLength){
                    maxLength = currentLength;
                }
                currentLength = i-preIndex;
            }
            positions[index] = i;
        }
        if (currentLength > maxLength){
            maxLength = currentLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcbb"));
    }
}
