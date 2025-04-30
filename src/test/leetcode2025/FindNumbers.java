package test.leetcode2025;

/**
 * 统计位数为偶数的数字
 */
public class FindNumbers {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int v = num;
            while (v>=10){
                v/=100;
            }
            if(v==0){
                ans++;
            }
        }
        return ans;

    }
}
