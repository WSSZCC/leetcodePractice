package test.leetcode2025;

/**
 *
 */
public class MinimumSize {
    public  int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        long sum = 0;
        int right = Integer.MIN_VALUE;
        for (int num : nums) {
            sum+=num;
            right=Math.max(num,right);
        }
        if(sum<=maxOperations+n){
            return 1;
        }
        int left = (int) (sum/(maxOperations+n))-1;
        while (left+1<right){
            int mid = left+(right-left)/2;
            if(check(mid,nums,maxOperations)){
                right=mid;
            }else {
                left=mid;
            }

        }
        return right;
    }

    private boolean check(int maxValue, int[] nums, int max) {
        int count = 0;
        for (int num : nums) {
            count+=(num-1)/maxValue;
        }
        return count<=max;
    }
}
