package 笔试题;

import java.util.Scanner;

/**
 * @author WilderGao
 * time 2019-09-18 15:54
 * motto : everything is no in vain
 * description
 */
public class MeituanOne {
    public static String isTrue(String s){
        if (!s.contains("true") && !s.contains("false")){
            return "error";
        }
        String[] ss = s.split("or");
        for (String s1 : ss){
            if (checkTrue(s1)){
                return "true";
            }
        }
        return "false";
    }

    private static boolean checkTrue(String s){
        String[] ss = s.split("and");
        boolean result;
        if (ss[0].contains("true")){
            result = true;
        }else {
            result = false;
        }
        if (ss.length == 1) return result;

        for (int i = 1; i < ss.length; i++) {
            if (ss[i].contains("false") && result){
                return false;
            }
            if (ss[i].contains("true") && !result){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(isTrue(s));
    }
}
