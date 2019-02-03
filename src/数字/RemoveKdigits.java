package 数字;

/**
 * @author wilder
 * @date 18-11-12 下午5:25
 * motto leetcode 402
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
输入: num = "1432219", k = 3
输出: "1219"
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。

示例 2 :
输入: num = "10200", k = 1
输出: "200"
解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 */
public class RemoveKdigits {

    public String solution(String num, int k){
        int numLength = num.length() - k;
        char[] result = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char index = num.charAt(i);
            while (top > 0 && result[top - 1] > index && k > 0){
                top -- ;
                k -- ;
            }
            result[top ++] = index;
        }
        int start = 0;
        while(start < numLength && result[start] == '0'){
            start ++ ;
        }
        return start == numLength? "0" :new String(result, start, numLength-start);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKdigits().solution("1432219",3));
    }
}
