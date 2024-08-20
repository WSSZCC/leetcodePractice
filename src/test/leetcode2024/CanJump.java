package test.leetcode2024;

/**
 * 跳跃游戏
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            if(nums[i]==0){
                return false;
            }
            nums[i+1] = Math.max(nums[i+1],nums[i]-1);
        }
        return true;
    }
}
