package 笔试题;

import java.util.Scanner;

/**
 * @author WilderGao
 * time 2019-09-28 20:45
 * motto : everything is no in vain
 * description
 */
public class KuaiShouOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");
        int studentNum = Integer.parseInt(ss[0]);
        int qNum = Integer.parseInt(ss[1]);
        char[][] solutions = new char[studentNum][qNum];
        for (int i = 0; i < studentNum; i++) {
            String solutionLine = in.nextLine();
            for (int j = 0; j < qNum; j++) {
                solutions[i][j] = solutionLine.charAt(j);
            }
        }
        int[] point = new int[qNum];
        for (int i = 0; i < qNum; i++) {
            point[i] = in.nextInt();
        }

        int[] maxSame = new int[5];
        int result = 0;

        for (int j = 0; j < qNum; j++) {
            for (int k = 0; k < 5; k++) {
                maxSame[k] = 0;
            }
            for (int i = 0; i < studentNum; i++) {
                maxSame[solutions[i][j] - 'A']++;
            }
            int max = 0;
            for (int i = 0; i < 5; i++) {
                max = Math.max(maxSame[i], max);
            }
            result += max * point[j];
        }
        System.out.println(result);
    }
}
