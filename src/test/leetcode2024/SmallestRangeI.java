package test.leetcode2024;

/**
 * 最小差值 I
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            if(minValue>num){
                minValue = num;
            }
            if(maxValue<num){
                maxValue = num;
            }
        }
        return Math.max(maxValue-minValue-2*k,0);
    }
}
