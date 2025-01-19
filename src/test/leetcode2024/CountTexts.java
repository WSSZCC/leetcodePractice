package test.leetcode2024;

/**
 *
 */
public class CountTexts {
    long[] data1;
    long[] data2;
    int mod = 1000000007;

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        buildData(n+1);
        long ans = 1;
        int flag = 0;
        for (int i = 0; i < n; i++) {
            flag++;
            if(i==n-1||pressedKeys.charAt(i)!=pressedKeys.charAt(i+1)){
                ans = ans*((pressedKeys.charAt(i)=='7'||pressedKeys.charAt(i)=='9')?data2[flag]:data1[flag])%mod;
                flag=0;
            }
        }
        return (int) ans;
    }

    public void buildData(int n){
        data1 = new long[Math.max(n,4)];
        data2 = new long[Math.max(n,4)];
        data1[0] = 1;
        data1[1] = 1;
        data1[2] = 2;
        data1[3] = 4;
        data2[0] = 1;
        data2[1] = 1;
        data2[2] = 2;
        data2[3] = 4;
        for (int i = 4; i < n; i++) {
            data1[i] = (data1[i-1]+data1[i-2]+data1[i-3])%mod;
            data2[i] = (data2[i-1]+data2[i-2]+data2[i-3]+data2[i-4])%mod;
        }
    }
}
