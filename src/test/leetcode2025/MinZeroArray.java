package test.leetcode2025;

/**
 * 零数组变换 II
 */
public class MinZeroArray {
    boolean isTrue = false;
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = -1;
        int right = queries.length+1;
        while (left+1<right){
            int mid = left+(right-left)/2;
            if(isZeroArray(nums,queries,mid)){
                right=mid;
            }else {
                left=mid;
            }
        }
        return isTrue?right:-1;

    }
    public boolean isZeroArray(int[] nums, int[][] queries,int index) {
        int n = nums.length;
        int[] ints = new int[n + 1];
        for (int i = 0; i < index; i++) {
            ints[queries[i][0]]+=queries[i][2];
            ints[queries[i][1]+1]-=queries[i][2];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=ints[i];
            if(nums[i]>sum){
                return false;
            }
        }
        isTrue = true;
        return true;
    }
}
