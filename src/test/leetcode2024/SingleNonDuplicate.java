package test.leetcode2024;

/**
 * 有序数组中的单一元素
 */
public class SingleNonDuplicate {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{10}));
        System.out.println(singleNonDuplicate(new int[]{0,1,1}));
        System.out.println(singleNonDuplicate(new int[]{0,0,1}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2,2,3,3,4,8,8}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = Math.max(n-2,0);
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if(mid%2==0){
                if(nums[mid]==nums[mid-1]){
                    right = mid-2;
                }else {
                    left = mid+2;
                }
            }else {
                if(nums[mid]==nums[mid-1]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return right==0?nums[right]:nums[left];
    }
}
