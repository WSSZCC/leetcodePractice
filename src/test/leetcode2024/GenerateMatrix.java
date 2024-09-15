package test.leetcode2024;

import java.util.Arrays;

/**
 * 螺旋矩阵 II
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        generateMatrix(3);
    }
    public static int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        boolean[][] booleans = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(booleans[i],false);
        }
        int[] ints1 = {1, 1, -1, -1};
        int flag = 0;
        int i = 0;
        int j = 0;
        int num = 1;
        int count = 0;
        while (true){
            if(!booleans[i][j]) {
                ints[i][j] = num;
                booleans[i][j] = true;
            }
            if(flag==0||flag==2){
                j+=ints1[flag];
               if(j<0||j>=n||booleans[i][j]){
                   j-=ints1[flag];
                   flag++;
                   flag %=4;
                   count++;
               }else {
                   num++;
                   count=0;
               }
            }else {
                i+=ints1[flag];
                if(i<0||i>=n||booleans[i][j]){
                    i-=ints1[flag];
                    flag++;
                    flag %=4;
                    count++;
                }else {
                    num++;
                    count=0;
                }
            }

            if(count>1){
                break;
            }
        }
        return ints;
    }
}
