package test.leetcode2024;

/**
 * 第 N 个泰波那契数
 */
public class Tribonacci {
    public static void main(String[] args) {

    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int a = 0, b = 1, c = 1, d = 2;
        for (int i = 0; i < n; i++) {
            a = b;
            b = c;
            c = d;
            d = a + b + c;
        }
        return d;
    }
}
