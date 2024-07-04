package test.leetcode2024;

/**
 * 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        minCostClimbingStairs(new int[]{10,15,20});
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return cost[0];
        }
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] ints = new int[n];
        ints[0] = cost[0];
        ints[1] = cost[1];
        for (int i = 2; i < n; i++) {
            ints[i] = Math.min(ints[i-2],ints[i-1])+cost[i];
        }
        return Math.min(ints[n-1],ints[n-2]);
    }
}
