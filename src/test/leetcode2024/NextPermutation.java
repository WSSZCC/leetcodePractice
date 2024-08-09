package test.leetcode2024;

/**
 * 下一个排列
 */
public class NextPermutation {
    public static void main(String[] args) {
        nextPermutation(new int[]{5,4,7,5,3,2});
    }
    public static int[] nextPermutation(int[] nums) {
        int n = nums.length;
        if(n>1){
            boolean isChange = false;
            for (int i = n-2; i >=0; i--) {
                if(isChange){
                    break;
                }
                int value = Integer.MAX_VALUE;
                int index = -1;
                for (int j = i+1; j < n; j++) {
                    if(nums[i]<nums[j]){
                        isChange = true;
                        if(nums[j]<value){
                            value = nums[j];
                            index = j;
                        }
                    }
                }
                if(isChange){
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                    int flag = 0;
                    for (int j = i + 1; j < n; j++) {
                        for (int k = i+1; k < n - 1 - flag; k++) {
                            if (nums[k] > nums[k + 1]) {
                                int temp1 = nums[k + 1];
                                nums[k + 1] = nums[k];
                                nums[k] = temp1;
                            }
                        }
                        flag++;
                    }

                }
            }
            if(!isChange){
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n-1-i; j++) {
                        if(nums[j]>nums[j+1]){
                            int temp = nums[j+1];
                            nums[j+1] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
            }
        }
        return nums;
    }
}
