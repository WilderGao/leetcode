package 辗转相除法;

/**
 * @author Wilder Gao
 * time:2018/8/17
 * description：求最大公约数
 * motto: All efforts are not in vain
 */
public class MaxDivisor {
    public int gcd(int numberA, int numberB) {
        if (numberA == numberB) {
            return numberA;
        }
        if (numberA < numberB) {
            return gcd(numberB, numberA);
        } else {

            /**
             * 辗转相除法：数A和数B的最大公约数等于A除以B的余数C和B的最大公约数
             * 更相减损术：两个正整数a和b（a>b），它们的最大公约数等于a-b的差值
             * c和较小数b的最大公约数。比如10和25，25减去10的差是15,那么10和25的最大公约数，等同于10和15的最大公约数。
             *
             * 但是，辗转相除法有一个缺点就是余数取模运算的性能较低，更相减损术的缺点就是当两个数相差过大的时候会进行很多不必要的运算，
             * 比如计算10000和1需要递归9999次
             *
             * 众所周知，移位运算的性能非常快。对于给定的正整数a和b，不难得到如下的结论。其中gcb(a,b)的意思是a,b的最大公约数函数：
             * 当a和b均为偶数，gcb(a,b) = 2*gcb(a/2, b/2) = 2*gcb(a>>1, b>>1)
             * 当a为偶数，b为奇数，gcb(a,b) = gcb(a/2, b) = gcb(a>>1, b)
             * 当a为奇数，b为偶数，gcb(a,b) = gcb(a, b/2) = gcb(a, b>>1)
             * 当a和b均为奇数，利用更相减损术运算一次，gcb(a,b) = gcb(b, a-b)， 此时a-b必然是偶数，又可以继续进行移位运算。
             */

            if ((numberA & 1) == 0 && (numberB & 1) == 0) {
                //两个数和1与之后都为0就说明是偶数
                return gcd(numberA >> 1, numberB >> 1) << 1;
            } else if ((numberA & 1) != 0 && (numberB & 1) == 0) {
                //A是奇数B是偶数的情况下
                return gcd(numberA, numberB >> 1);
            } else if ((numberA & 1) == 0 && (numberB & 1) != 0) {
                //A是偶数B是奇数的情况下
                return gcd(numberA >> 1, numberB);
            } else {
                return gcd(numberB, numberA - numberB);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaxDivisor().gcd(100, 30));
    }
}
