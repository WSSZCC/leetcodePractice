package test.leetcode2024;

/**
 * 所有数对中数位差之和
 */
public class SumDigitDifferences {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        String s = String.valueOf(nums[0]);
        int m = s.length();
        int[][] ints = new int[m][10];
        genInts(nums, m, ints);
        long count = 0;
        count = calTotalCount(n, ints, count);
        return count;
    }

    private long calTotalCount(int n, int[][] ints, long count) {
        for (int[] anInt : ints) {
            int len = n;
            for (int i : anInt) {
                if (len == 0) {
                    break;
                }
                len -= i;
                count += (long) i * len;
            }
        }
        return count;
    }

    private void genInts(int[] nums, int m, int[][] ints) {
        for (int num : nums) {
            String s1 = String.valueOf(num);
            for (int j = 0; j < m; j++) {
                ints[j][s1.charAt(j) - '0']++;
            }
        }
    }
}
