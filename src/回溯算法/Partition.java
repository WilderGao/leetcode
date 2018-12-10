package 回溯算法;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WilderGao
 * time 2018-12-10 20:54
 * motto : everything is no in vain
 * description 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Partition {
    public List<List<String>> solution(String s){
        List<List<String>> result = new LinkedList<>();
        List<String> tmp = new LinkedList<>();
        partitionDFS(result, tmp, s, 0);
        return result;
    }

    private void partitionDFS(List<List<String>> result, List<String> tmp, String s, int start){
        if (start == s.length()){
            //递归结束的标志
            List<String> index = new LinkedList<>(tmp);
            result.add(index);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)){
                //如果前半部分是回文字符串，那么递归后面那部分
                tmp.add(s.substring(start, i+1));
                partitionDFS(result, tmp, s, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    /**
     * 判断这个字符串的开始到结束部分是不是回文字符串
     * @param s 总字符串
     * @param start 开始部分
     * @param end   结束部分
     * @return 判断结果
     */
    private boolean isPalindrome(String s, int start, int end){
        while (start<end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Partition().solution("aab"));
    }
}
