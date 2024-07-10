package test.leetcode2024;

/**
 * 匹配模式数组的子数组数目 I
 */
public class CountMatchingSubarrays {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int count = 0;
        for (int i = 0; i < n-m; i++) {
            int index = i;
            int preValue = nums[index];
            for (int k : pattern) {
                if (!compareValueByNum(preValue, nums[index+1], k)) {
                    break;
                }
                index++;
                preValue = nums[index];
            }
            if(index-i==m){
                count++;
            }
        }
        return count;
    }

    private boolean compareValueByNum(int v1, int v2, int num) {
        if(num==0){
            return v1==v2;
        }
        if(num==1){
            return v1<v2;
        }
        return v1>v2;
    }
}
