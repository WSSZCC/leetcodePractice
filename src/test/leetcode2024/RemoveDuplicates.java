package test.leetcode2024;

/**
 * 删除有序数组中的重复项 II
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 0;
        int prePreValue = Integer.MIN_VALUE;
        int preValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prePreValue == preValue && preValue == nums[i]) {
                continue;
            }
            prePreValue = preValue;
            preValue = nums[i];
            if (i > index) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
            index++;
        }
        return index;
    }
}
