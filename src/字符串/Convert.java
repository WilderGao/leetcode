package 字符串;


/**
 * @author WilderGao
 * time 2019-10-19 16:23
 * motto : everything is no in vain
 * description
 */
public class Convert {
    public String solution(String s, int numRows) {
        if (s == null || s.length() == 0) return s;
        int length = s.length();
        int xieNum = numRows - 2 > 0 ? numRows - 2 : 0;
        int indexNum = numRows + xieNum;
        int partNum = length / indexNum + 1;
        char[][] result = new char[numRows][partNum * (1 + xieNum)];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = ' ';
            }
        }
        int it = 0;
        int i = 0, j = 0;
        while (it < length) {
            while (i < numRows && it < length){
                result[i][j] = s.charAt(it);
                i++;
                it++;
            }
            if (result.length == 1){
                i--;
            }else {
                i-=2;
            }
            j++;
            while (i > 0 && it < length){
                result[i][j] = s.charAt(it);
                i--;
                j++;
                it++;
            }
        }
        StringBuilder reb = new StringBuilder();
        for (int k = 0; k < result.length; k++) {
            for (int l = 0; l < result[0].length; l++) {
                if (result[k][l] != ' '){
                    reb.append(result[k][l]);
                }
            }
        }
        return reb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Convert().solution("AB", 1));
    }
}
