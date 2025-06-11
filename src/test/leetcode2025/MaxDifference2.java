package test.leetcode2025;

/**
 * 奇偶频次间的最大差值 II
 */
public class MaxDifference2 {
    // todo
    public int maxDifference(String s, int k) {
        int v1 = Integer.MAX_VALUE/2;
        int ans = -v1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(i==j){
                    continue;
                }
                int[] ints = new int[5];
                int[] ints1 = new int[5];
                int[][] ints2 = {{v1, v1}, {v1, v1}};
                int left = 0;
                for (int x = 0; x < s.length(); x++) {
                    ints[s.charAt(x)-'0']++;
                    int r = x+1;
                    while (r-left>=k&&ints[i]>ints1[i]&&ints[j]>ints1[j]){
                        int p = ints1[i] & 1;
                        int q = ints1[j] & 1;
                        ints2[p][q] = Math.min(ints2[p][q],ints1[i]-ints1[j]);
                        ints1[s.charAt(left)-'0']++;
                        left++;
                    }
                    ans = Math.max(ans,ints[i]-ints[j]-ints2[ints[i]&1^1][ints[j]&1]);
                }
            }
        }
        return ans;
    }
}
