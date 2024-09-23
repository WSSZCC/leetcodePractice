package test.leetcode2024;

/**
 * 最佳观光组合
 */
public class MaxScoreSightseeingPair {
    public static void main(String[] args) {
        maxScoreSightseeingPair(new int[]{10,4,6,4,10});
    }
    public static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] ints = new int[n-1];
        int[] ints1 = new int[n-1];
        for (int i = 0; i < n; i++) {
            if(i>0){
                ints1[i-1] = values[i]-i;
            }
            if(i<n-1){
                ints[i] = values[i]+i;
            }
        }
        ints1[0]+=ints[0];
        for (int i = 1; i < n-1; i++) {
            ints[i]=Math.max(ints[i-1],ints[i]);
            ints1[i] = Math.max(ints1[i-1],ints[i]+ints1[i]);
        }
        return ints1[n-2];
    }
}
