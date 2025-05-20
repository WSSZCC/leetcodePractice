package test.leetcode2025;

/**
 *  零数组变换 I
 */
public class IsZeroArray {
    public static void main(String[] args) {
        int[][] ints = {{1, 1}, {1, 1}};
        System.out.println(ints[0]==ints[1]);
    }
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] ints = new int[n];
        ints[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ints[i] = nums[i]-nums[i-1];
        }
        for (int[] query : queries) {
            ints[query[0]]-=1;
            if(query[1]+1<n){
                ints[query[1]+1]-=1;
            }
        }
        for (int i = 1; i < n; i++) {
            ints[i] +=ints[i-1];
        }
        for (int num : ints) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}
