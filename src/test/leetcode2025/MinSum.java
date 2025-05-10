package test.leetcode2025;

/**
 * 数组的最小相等和
 */
public class MinSum {
    public long minSum(int[] nums1, int[] nums2) {
        int count1 = 0;
        int count2 = 0;
        long sum  = 0;
        for (int i : nums1) {
            if(i==0){
                sum++;
                count1++;
            }
            sum+=i;
        }
        long ans=sum;
        for (int i : nums2) {
            if(i==0){
                sum--;
                count2++;
            }
            sum-=i;
        }
        ans+=Math.max(0,-sum);
       if(sum<0&&count1<=0||sum>0&&count2<=0){
           return -1;
       }
        return ans;
    }
}
