package test.leetcode2025;

/**
 * 给小朋友们分糖果 II
 */
public class DistributeCandies {
    public long distributeCandies(int n, int limit) {
        long ans = 0;
        int v1 = Math.min(n,limit);
        for (int i = 0; i <= v1; i++) {
            int v2 = Math.max(0, n - i - limit);
            int v3 = Math.min(limit, n - i);
            if(v2 <= v3){
                ans+=Math.max(Math.min(limit,n-i)-Math.max(0,n-i-limit)+1,0);
            }
        }
        return ans;
    }
}
