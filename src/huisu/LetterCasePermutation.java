package huisu;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Wilder Gao
 * time:2018/8/14
 * description：给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * motto: All efforts are not in vain
 */
public class LetterCasePermutation {

    public List<String> solution(String S){
        List<String> result = new LinkedList<>();
        find(result, new StringBuffer(S), 0);
        return result;
    }

    private void find(List<String> result, StringBuffer s, int index){
        if (index == s.length()){
            result.add(s.toString());
            return ;
        }
        char tmp = s.charAt(index);
        if (Character.isLetter(tmp)){
            s.setCharAt(index, Character.toLowerCase(tmp));
            find(result, s, index+1);
            s.setCharAt(index, Character.toUpperCase(tmp));
            find(result, s, index + 1);
        }else {
            find(result, s, index+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().solution("a1b2"));
    }
}
