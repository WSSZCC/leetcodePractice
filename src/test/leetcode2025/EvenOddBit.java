package test.leetcode2025;

/**
 * 奇偶位数
 */
public class EvenOddBit {
    public int[] evenOddBit(int n) {
        int[] ints = {0, 0};
        int flag=0;
        while (n>0){
            ints[flag]+=n&1;
            flag++;
            flag = flag%2;
            n>>=1;
        }
        return ints;
    }
}
