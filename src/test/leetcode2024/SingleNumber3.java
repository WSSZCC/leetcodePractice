package test.leetcode2024;

/**
 *
 */
public class SingleNumber3 {
    public  int[] singleNumber(int[] nums) {
        int value = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            value^=nums[i];
        }
        int flag = 0;
        while (((value>>flag)&1)!=1){
            flag++;
        }
        int v = 1<<flag;
        int v1 = 0;
        int v2 = 0;
        boolean isChange1 = false;
        boolean isChange2 = false;
        for (int num : nums) {
            if ((num & v) == v) {
                if (isChange1) {
                    v1 ^= num;
                } else {
                    v1 = num;
                    isChange1 = true;
                }
            } else {
                if (isChange2) {
                    v2 ^= num;
                } else {
                    v2 = num;
                    isChange2 = true;
                }
            }
        }
        return new int[]{v1,v2};

    }

}
