package test.leetcode2024;

import java.util.Arrays;

/**
 * 不含特殊楼层的最大连续楼层数
 */
public class MaxConsecutive {
    public int maxConsecutive(int bottom, int top, int[] special) {
        if(top-bottom+1==special.length){
            return 0;
        }
        Arrays.sort(special);
        int max = Math.max(special[0]-bottom,top-special[special.length-1]);
        int pre = special[0];
        for (int i = 1; i < special.length; i++) {
            if(pre+1!=special[i]){
                max = Math.max(max,special[i]-pre-1);
            }
            pre = special[i];
        }
        return max;

    }
}
