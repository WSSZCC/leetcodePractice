package test.leetcode2025;

/**
 *   统计恰好有 K 个相等相邻元素的数组数目
 */
public class CountGoodArrays {
    private static final int mod = 1000000007;
    private static final int max = 100000;

    private static final long[] ints = new long[max];
    private static final long[] ints1 = new long[max];
    private static boolean init = false;

    private void build() {
        if(init){
            return;
        }
        ints[0] = 1;
        for (int i = 1; i < max; i++) {
            ints[i] = ints[i - 1] * i % mod;
        }
        ints1[max - 1] = pow(ints[max - 1], mod - 2);
        for (int i = max - 1; i > 0; i--) {
            ints1[i - 1] = ints1[i] * i % mod;
        }
        init = true;
    }

    private long pow(long x, int n) {
        long ans = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                ans = ans * x % mod;
            }
            x = x * x % mod;
        }
        return ans;
    }

    public int countGoodArrays(int n, int m, int k) {
        build();
        return (int) (comb(n - 1, k) * m % mod * pow(m - 1, n - 1 - k) % mod);
    }

    private long comb(int i, int k) {
        return ints[i] * ints1[k] % mod * ints1[i - k] % mod;
    }
}
