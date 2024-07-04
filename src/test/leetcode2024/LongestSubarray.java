package test.leetcode2024;

/**
 *  删掉一个元素以后全为 1 的最长子数组
 */
public class LongestSubarray {
    public static void main(String[] args) {

    }

    public static int longestSubarray(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int firstIndex = 0;
        int lastIndex = -1;
        int firstZeroIndex = 0;
        while (lastIndex < n - 1) {
            int count = 1;
            int flag = 1;
            for (int i = firstIndex; i < nums.length; i++) {
                if (nums[i] == 0) {
                    if (count == 1) {
                        firstZeroIndex = i;
                        count--;
                    }
                    flag--;
                }
                if (flag < 0) {
                    break;
                }
                lastIndex = i;
            }
            ans = Math.max(ans, lastIndex - firstIndex + 1);
            firstIndex = firstZeroIndex + 1;
        }

        return ans-1;
    }

}
