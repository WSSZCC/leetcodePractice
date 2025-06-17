package test.leetcode2025;

public class MinCut {
    public static void main(String[] args) {
        FindKthNumber countOfSubstrings = new FindKthNumber();
        countOfSubstrings.findKthNumber(2,2);
    }
    int ans;

    public int minCut(String s) {
        ans = Integer.MAX_VALUE;
        backtrack(s, s.length(), 0, 0);
        return ans;
    }

    private void backtrack(String s, int n, int index, int temp) {
        if (index == n) {
            ans = Math.min(temp, ans);
            return;
        }
        int len = 1;
        while (len <= n - index) {
            String s1 = s.substring(index, index + len);
            if (!s1.equals(new StringBuilder(s1).reverse().toString())) {
                len++;
                continue;
            }
            backtrack(s, n, index + len, temp + 1);
            len++;
        }
    }
}
