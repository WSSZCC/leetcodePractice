package test.leetcode2024;

/**
 * 搜索旋转排序数组 II
 */
public class Search81 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,0,1,1,1},0));
    }
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        int firstValue = nums[0];
        int lastValue = nums[n-1];
        if(firstValue==target||lastValue==target){
            return true;
        }
        int left = 0;
        int right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[left]==nums[mid]){
                left++;
                continue;
            }
            if(nums[left]<nums[mid]){
                if(nums[mid]>target&&nums[left]<=target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if(nums[mid]<target&&nums[right]>=target){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }


        }
        return false;

    }

    /**
     * @param nums
     * @param target
     *  数据量不大简直无敌
     * @return
     */
    public boolean search1(int[] nums, int target) {
        int n = nums.length;
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;

    }
}
