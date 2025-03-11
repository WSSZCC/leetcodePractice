package test.leetcode2025;

/**
 *
 */
public class DivisorSubstrings {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(10101010, 2));
    }

    public static int divisorSubstrings(int num, int k) {
        int temp = num;
        int ans = 0;
        int sum = 0;
        int v = 1;
        while (temp > 0) {
            while (k > 1) {
                int i = temp % 10;
                temp /= 10;
                sum += i * v;
                v *= 10;
                k--;
            }
            int i = temp % 10;
            temp /= 10;
            sum += v * i;
            if (sum != 0 && num % sum == 0) {
                ans++;
            }
            sum/=10;
        }
        return ans;
    }
}
