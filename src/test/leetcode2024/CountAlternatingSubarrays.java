package test.leetcode2024;

/**
 * 交替子数组计数
 */
public class CountAlternatingSubarrays {
    public static void main(String[] args) {
        System.out.println(countAlternatingSubarrays(new int[]{0,1,1,1}));
    }
    public static long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long totalCount = 0;
        int currentLen = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i]==nums[i-1]){
                for (int j = 1; j <= currentLen; j++) {
                    totalCount+=j;
                }
                currentLen = 0;
            }
            currentLen++;
        }
        for (int i = 1; i <= currentLen; i++) {
            totalCount +=i;
        }
        return totalCount;
    }
}
