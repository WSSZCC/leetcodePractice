package test.leetcode2024;

/**
 * 比特位计数
 */
public class CountBits {
    public static void main(String[] args) {
        countBits(10);
    }

    public static int[] countBits(int n) {
        int[] ints = new int[n+1];
        for (int i = 0; i <= n; i++) {
           ints[i] =  getOneCount(i, 0);
        }
        return ints;
    }

    private static int getOneCount(int n, int count) {
        if (n % 2 == 1) {
            count++;
        }
        if (n / 2 == 0) {
            return count;
        }
        return getOneCount(n/2, count);
    }
}
