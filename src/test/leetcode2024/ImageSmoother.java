package test.leetcode2024;

import java.util.Arrays;

/**
 * 图片平滑器
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] ints = new int[n][m];
        int[][] ints1 = {{1, 1, 1, 0, 0, -1, -1, -1}, {-1, 0, 1, -1, 1, -1, 0, 1}};
        for (int i = 0; i < n; i++) {
            Arrays.fill(ints[i],0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 1;
                int value = img[i][j];
                for (int k = 0; k < ints1[0].length; k++) {
                    int x = i+ints[0][k];
                    int y = j+ints[1][k];
                    if(x<0||x>=n||y<0||y>=m){
                        continue;
                    }
                    count++;
                    value+=img[x][y];
                }
                ints[i][j] = value/count;
            }
        }
        return ints;
    }
}
