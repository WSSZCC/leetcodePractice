package test.leetcode2024;

/**
 * Pow(x, n)
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (x == 0) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        int flag = 0;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                flag++;
                n++;
            }
            n = -n;
            x = 1 / x;
        }
        double value = 1;
        double temp = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                value *= temp;
            }
            temp *= temp;
            n >>= 1;
        }
        if (flag == 1) {
            value *= x;
        }
        return value;
    }
}
