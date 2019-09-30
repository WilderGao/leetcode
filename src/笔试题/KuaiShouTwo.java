package 笔试题;

import java.util.Scanner;

/**
 * @author WilderGao
 * time 2019-09-28 20:03
 * motto : everything is no in vain
 * description
 */
public class KuaiShouTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        String line = in.nextLine();
        int length = line.length();
        if (getNum(line) < k) {
            System.out.println(0);
            return;
        }
        int finalNum = 0;
        for (int i = 0; i < length - k + 1; i++) {
            for (int j = i + k + 1; j <= length; j++) {
                String child = line.substring(i, j);
                if (getNum(child) == k) {
                    finalNum++;
                }
            }
        }
        System.out.println(finalNum);
    }

    private static int getNum(String child) {
        int oneNum = 0;
        return child.replaceAll("0", "").length();
    }
}
