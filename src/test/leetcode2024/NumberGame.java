package test.leetcode2024;

/**
 * 最小数字游戏
 */
public class NumberGame {
    public static void main(String[] args) {

    }
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if(nums[j]>nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }
        int i = 0;
        while (i<n){
            swap(nums,i,i+1);
            i = i+2;
        }
        return nums;
    }
    private static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
