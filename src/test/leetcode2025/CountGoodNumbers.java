package test.leetcode2025;

/**
 * 统计好数字的数目
 */
public class CountGoodNumbers {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
    }
    public static int countGoodNumbers(long n) {
        int ans = 1;
        int mod = 1000000007;
        if(n%2==1){
            n--;
            ans *= 5;
        }
        n/=2;
        long flag = 20;
        while (n>0){
            if((n&1)==1){
                ans = (int) ((ans*flag)%mod);
            }
            n>>=1;
            flag=(flag*flag)%mod;
        }
        return ans;
    }
}
