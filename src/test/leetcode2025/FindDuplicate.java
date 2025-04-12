package test.leetcode2025;

/**
 * 寻找重复数
 */
public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
    }
    public static int findDuplicate(int[] nums) {
        int v1 = nums[0];
        int v2 = nums[nums[0]];
        while (nums[v1]!=nums[v2]){
            v1 = nums[v1];
            v2 = nums[nums[v2]];
        }
        int v3 = 0;
        int v4 = v1;
        while (nums[v3]!=nums[v4]){
            v3 = nums[v3];
            v4 = nums[v4];
        }
        return nums[v3];
    }
}
