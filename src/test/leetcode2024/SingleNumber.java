package test.leetcode2024;

/**
 * 只出现一次的数字
 */
public class SingleNumber {
    public static void main(String[] args) {
        singleNumber(new int[]{4,1,2,1,2});

    }

    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        boolean isTrue = true;
        for (int num : nums) {

        }
        while(i<n-1){
            int res = nums[i];
            for (int j = i+1; j < n; j++) {
                if(res == nums[j]){
                    int temp = nums[i+1];
                    nums[i+1] = nums[j];
                    nums[j] = temp;
                    isTrue = false;
                }
            }
            if(isTrue){
                return res;
            }
            i = i+2;
            isTrue = true;
        }
        return nums[i];
    }
}
