package 字符串;

/**
 * @author WilderGao
 * time 2019-09-30 15:04
 * motto : everything is no in vain
 * description leetcode 242
 */
public class IsAnagram {
    public static boolean solution(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) return false;
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) return false;
        int[] index = new int[256];
        for (int i = 0; i < sLength; i++) {
            index[s.charAt(i)]++;
            index[t.charAt(i)]--;
        }
        for (int i = 0; i < index.length; i++) {
            if (index[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("rat", "car"));
    }
}
