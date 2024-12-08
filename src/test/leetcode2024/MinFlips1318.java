package test.leetcode2024;

/**
 *  或运算的最小翻转次数
 */
public class MinFlips1318 {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a>=0||b>=0||c>=0){
            if((c&1)==1&&(a&1)!=1&&(b&1)!=1){
                    count++;
            }
            if((c&1)!=1){
                if((a&1)==1) {
                    count++;
                }
                if((c&1)==1){
                    count++;
                }
            }
            a>>=1;
            b>>=1;
            c>>=1;

        }
        return count;
    }
}
