package jianzhi;

/**
 * @author WilderGao
 * time 2019-04-13 09:30
 * motto : everything is no in vain
 * description 数值的整数次方
 */
public class Sixteen {
    private double power(double base, int exponent) {
        //底数为0没有意义,底数为0指数小于0不符合
        if (Double.doubleToLongBits(base) == Double.doubleToLongBits(0.0) && exponent < 0){
            return 0.0;
        }
        //要判断exponent小于0的情况
        int absExponent = Math.abs(exponent);
        double result = withUnsignedExponent(base, absExponent);
        if (exponent < 0){
            result = 1.0/result;
        }
        return result;
    }

    private double withUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }
        double result = withUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Sixteen().power(2,8));
    }
}
