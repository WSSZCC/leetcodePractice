package test.leetcode2024;

/**
 * 找到最高海拔
 */
public class LargestAltitude {
    public static void main(String[] args) {

    }

    private static int largestAltitude(int[] gain) {
        int ans = 0;
        int temp = 0;
        for (int j : gain) {
            temp += j;
            ans = Math.max(temp, ans);
        }
        return ans;
    }

}
