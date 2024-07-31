package test.leetcode2024;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 覆盖所有点的最少矩形数目
 */
public class MinRectanglesToCoverPoints {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(a->a[0]));
        int[] point = points[0];
        int rowIndex = point[0]+w;
        int count = 1;
        for (int[] ints : points) {
            if(ints[0]>rowIndex){
                rowIndex = ints[0]+w;
                count++;
            }
        }
        return count;
    }
}
