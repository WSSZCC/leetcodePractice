package test.leetcode2024;

/**
 * 价值和小于等于 K 的最大数字
 */
public class FindMaximumNumber {
    public static void main(String[] args) {
        findMaximumNumber(9,1);
    }
    public static long findMaximumNumber(long k, int x) {
        long num = (k+1)<<x;
        long left = 1;
        long right = num;
        while (left<=right){
            long mid = left+(right-left)/2;
            long price = calPrice(mid,x);
            if(price<=k){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return right;
    }

    private static long calPrice(long mid,int x) {
        int k = x-1;
        long res = 0;
        for (long i = mid>>k; i > 0; i>>=x) {
            res += (i/2)<<k;
            if(i%2>0){
                long mas = (1L<<k)-1;
                res += (mas&mid)+1;
            }
            k+=x;
        }
        return res;
    }
}
