package test.leetcode2024;

/**
 * 求出数字答案
 */
public class GenerateKey {

    public int generateKey(int num1, int num2, int num3) {
        if (num1 == 0 || num2 == 0 || num3 == 0) return 0;
        int v2 = Math.min(num2 % 10, num3 % 10);
        int v1 = Math.min(num1 % 10, v2);
        return v1 + 10 * generateKey(num1 / 10, num2 / 10, num3 / 10);
    }
}
