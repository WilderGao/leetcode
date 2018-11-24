package 数字;

/**
 * @author wilder
 * @date 18-11-12 下午5:25
 * motto
 */
public class RemoveKdigits {
    public String solultion(String num, int k){
        int numlength = num.length() - k;
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
        while(start < numlength && result[start] == '0'){
            start ++ ;
        }
        return start == numlength? "0" :new String(result, start, numlength-start);
    }
}
