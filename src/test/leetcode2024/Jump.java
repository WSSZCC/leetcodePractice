package test.leetcode2024;

import java.util.Arrays;

/**
 * 跳跃游戏 II
 */
public class Jump {
    public static void main(String[] args) {
        jump(new int[]{2,3,1,4,4});
    }
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] ints = new int[n];
        Arrays.fill(ints,0);
        for (int i = 0; i < n-1; i++) {
            int num = nums[i];
            for (int j = i+1; j <=Math.min(num+i,n-1); j++) {
                ints[j] = ints[j]==0?ints[i]+1:Math.min(ints[j],ints[i]+1);
            }
        }
        return ints[n-1];
    }
}
