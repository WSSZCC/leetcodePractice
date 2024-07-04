package test.leetcode2024;

/**
 * 相同分数的最大操作数目 I
 */
public class MaxOperations {
    public static void main(String[] args) {

    }
    public static int maxOperations(int[] nums) {
        int n = nums.length;
        int sum = nums[0]+nums[1];
        if(n==2){
            return 1;
        }
        int count = 1;
        int flag = 2;
        while (flag<n-1){
            int a = nums[flag];
            int b = nums[flag+1];
            if(a+b!=sum){
                break;
            }
            flag = flag+2;
            count++;
        }
        return count;
    }
}
