package test.leetcode2024;

/**
 * 使两个整数相等的位更改次数
 */
public class MinChanges {
    public int minChanges(int n, int k) {
        if(n<k){
            return -1;
        }
        if(n==k){
            return 0;
        }
        int count = 0;
        while (n>0){
            if((n&1)==0&&(k&1)==1){
                return -1;
            }
            if((n&1)==1&&(k&1)==0){
                count++;
            }
            n>>=1;
            k>>=1;
        }
        return count;
    }

}
