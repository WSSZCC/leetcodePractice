package test.leetcode2024;

/**
 * 访问数组中的位置使分数最大
 */
public class MaxScore1 {
    public static void main(String[] args) {
        maxScore(new int[]{2,7,6,1,9,2},5);

    }

    public static long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[] ints = new long[n];
        boolean[] booleans = new boolean[n];
        for (int i = 0; i < n; i++) {
            booleans[i] = nums[i] % 2 == 0;
        }
        int index = 0;
        ints[0] = nums[0];
        boolean isOdd = false;
        for (int i = 1; i < n; i++) {
            long temp = nums[i] + ints[i - 1];
            index = i+1;
            if(booleans[i]!=booleans[0]){
                ints[i] = temp - x;
                isOdd = booleans[i];
                break;
            }
            ints[i]= temp;
        }
        for (int i = index; i < n; i++) {
            if(booleans[i]==isOdd){
                ints[i] = ints[i-1]+nums[i];
                ints[i-1] = ints[i-2];
            }else {
                ints[i]=Math.max(ints[i-1]+nums[i]-x,ints[i-2]+nums[i]);
                isOdd = booleans[i];
            }
        }
        return Math.max(ints[n-1],ints[n-2]);
    }
}
