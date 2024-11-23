package test.leetcode2024;

/**
 * 统计不是特殊数字的数字数量
 */
public class NonSpecialCount {
    public int nonSpecialCount(int l, int r) {
        int maxLen=r-l+1;
        long left = Math.round(Math.sqrt(l));
        if(left*left<l){
            left++;
        }
        long right = (long)Math.floor(Math.sqrt(r));
        for(long i=Math.max(left,2);i<=right;i++){
            boolean isTrue = false;
            for(long j = 2;j<=Math.round(Math.sqrt(i));j++){
                if(i%j==0){
                    isTrue=true;
                    break;
                }
            }
            if(isTrue){
                continue;
            }
            maxLen--;
        }
        return maxLen;
    }
}
