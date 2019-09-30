package 笔试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WilderGao
 * time 2019-09-18 16:24
 * motto : everything is no in vain
 * description
 */
public class MeituanTwo {
    public static void help(double[][] comments, int num) {
        double[][] help = comments;
        double result = 0;
        List<List<Integer>> position = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            int j = 0, k = 0;
            //找到最大值
            double max = Double.MIN_VALUE;
            for (int l = 0; l < help.length; l++) {
                for (int m = 0; m < help[0].length; m++) {
                    if (max < help[l][m]) {
                        max = help[l][m];
                        j = l;
                        k = m;
                    }
                }
            }
            result += max;
            double p = help[j][k];
            int z = j, x = k;
            for (int l = 0; l < comments.length; l++) {
                for (int m = 0; m < comments[0].length; m++) {
                    if (comments[l][m] == p){
                        z = l;
                        x = m;
                        break;
                    }
                }
            }

            List<Integer> list = new ArrayList<>();
            list.add(z+1);
            list.add(x+1);
            position.add(0, list);

            //更新矩阵
            double[][] updateHelp = new double[num-i][num-i];
            int weight = 0, height = 0;
            for (int l = 0; l < help.length; l++) {
                if (l == j) continue;
                for (int m = 0; m < help[0].length; m++) {
                    if (m == k) continue;
                    updateHelp[weight][height++] = help[l][m];
                }
                height = 0;
                weight++;
            }
            help = updateHelp;
        }
        System.out.println(result);
        for (List<Integer> integers : position) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] comments = new double[3][3];
        comments[0][0] = 1.08;
        comments[0][1] = 1.25;
        comments[0][2] = 1.5;
        comments[1][0] = 1.5;
        comments[1][1] = 1.35;
        comments[1][2] = 1.75;
        comments[2][0] = 1.22;
        comments[2][1] = 1.48;
        comments[2][2] = 2.5;
        help(comments, 3);
    }

}
