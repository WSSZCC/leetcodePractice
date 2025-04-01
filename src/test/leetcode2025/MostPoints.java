package test.leetcode2025;

import java.util.Arrays;

/**
 * 2140. 解决智力问题
 */
public class MostPoints {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] longs = new long[n];
        Arrays.fill(longs,0);
        longs[n-1] = questions[n-1][0];
        for (int i = n-2; i >= 0; i--) {
            int[] question = questions[i];
            if(i+question[1]+1>n-1){
                longs[i] = Math.max(question[0],longs[i+1]);
            }else {
                longs[i] = Math.max(question[0]+longs[i+question[1]+1],longs[i+1]);
            }
        }
        return longs[0];
    }
}
