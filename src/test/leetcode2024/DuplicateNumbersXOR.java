package test.leetcode2024;

import java.util.Arrays;

/**
 * 求出出现两次数字的 XOR 值
 */
public class DuplicateNumbersXOR {
    public int duplicateNumbersXOR(int[] nums) {
        Arrays.sort(nums);
        int preValue = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if(preValue!=nums[i]){
                preValue = nums[i];
                continue;
            }
            res^=preValue;
        }
        return res;
    }
}
