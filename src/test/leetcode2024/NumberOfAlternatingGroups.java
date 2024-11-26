package test.leetcode2024;

/**
 * 交替组 I
 */
public class NumberOfAlternatingGroups {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int pre = colors[n-1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(pre == colors[i]){
                continue;
            }
            if(colors[(i-1+n)%n]==colors[(i+1)%n]&&colors[(i+1)%n]==colors[i]){
                ans++;
            }
            pre = colors[i];
        }
        return ans;
    }
}
