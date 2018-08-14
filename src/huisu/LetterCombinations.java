package huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wilder Gao
 * time:2018/8/8
 * description：电话号码的字母组合（回溯算法的实现）
 * motto: All efforts are not in vain
 */
public class LetterCombinations {

    static String[] a = new String[] {"","","abc","def",
            "ghi","jkl","mno","pqrs","tuv","wxyz"};
    static StringBuffer sb = new StringBuffer();

    public List<String> getInstance(String digits){
        if (digits.length() == 0) {
            return null;
        }
        List<String> answer = new ArrayList<>();
        huisu(digits, 0, answer);
        //开始回溯
        return answer;
    }

    private static void huisu(String digits, int n, List<String> answer){
        if (n == digits.length()){
            answer.add(sb.toString());
            return;
        }

        for (int i =0; i< a[digits.charAt(n)-'0'].length();i++){
            sb.append(a[digits.charAt(n)-'0'].charAt(i));
            huisu(digits, n+1, answer);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new LetterCombinations().getInstance("23"));
    }

}
