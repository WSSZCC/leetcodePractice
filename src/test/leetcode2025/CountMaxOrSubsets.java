package test.leetcode2025;

/**
 * 统计按位或能得到最大值的子集数目
 */
public class CountMaxOrSubsets {
    int ans;
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
         ans =0;
        for (int num : nums) {
            max|=num;
        }
        dfs(0,0,nums,max);
        return ans;
    }

    private void dfs(int i, int sum, int[] nums, int max) {
        if(sum==max){
            ans++;
        }
        for (int j = i; j < nums.length; j++) {
            dfs(j+1,sum|nums[j],nums,max);
        }
    }
}
