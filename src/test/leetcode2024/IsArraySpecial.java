package test.leetcode2024;

/**
 * 特殊数组 I
 */
public class IsArraySpecial {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        if(n<=1){
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            int preValue = nums[i-1]%2;
            int curValue = nums[i]%2;
            if((preValue==0&&curValue==0||(preValue==1&&curValue==1))){
                return false;
            }
        }
        return true;
    }
}
