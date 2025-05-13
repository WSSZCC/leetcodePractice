package test.leetcode2025;

/**
 * 字符串转换后的长度 I
 */
public class LengthAfterTransformations {
    public int lengthAfterTransformations(String s, int t) {
        int mod = 1000000007;
        int[] ints = new int[26];
        for (char c : s.toCharArray()) {
            ints[c-'a']++;
        }
        while (t>=26){
            long value = ints[0];
            for (int i = 1; i < 26; i++) {
                long temp = ints[i];
                ints[i] = (int) ((value+ints[i])%mod);
                value = temp;
                if(i==25){
                    ints[0] = (int) ((temp+ints[0])%mod);
                    ints[1] = (int) ((temp+ints[1])%mod);
                }
            }
            t-=26;
        }
        long sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum+=ints[i];
            if(t+i>=26){
                sum+=ints[i];
            }
        }
        return (int) (sum%mod);
    }
}
