package test.leetcode2025;

/**
 * 找出有效子序列的最大长度 I
 */
public class MaximumLength {
    public int maximumLength(int[] nums) {
        int ans = 2;

        int[][] ints = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        for (int[] anInt : ints) {
            int pre1 = anInt[0];
            int pre2 = anInt[0];
            int flag = 0;
            for (int num : nums) {
                if(num%2!=pre1){
                    continue;
                }
                flag++;
                pre1 = pre2;
                pre2 = num%2;
            }
            ans = Math.max(ans,flag);
        }

        return ans;

    }
}
