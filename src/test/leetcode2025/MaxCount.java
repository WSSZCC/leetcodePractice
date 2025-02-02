package test.leetcode2025;

/**
 * 区间加法 II
 */
public class MaxCount {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0){
            return m*n;
        }
        int v1 = Integer.MAX_VALUE;
        int v2 = Integer.MAX_VALUE;
        for (int[] op : ops) {
            v1 = Math.min(op[0],v1);
            v2 = Math.min(op[1],v2);
        }
        return v1*v2;
    }
}
