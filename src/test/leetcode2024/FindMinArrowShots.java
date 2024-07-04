package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 用最少数量的箭引爆气球
 */
public class FindMinArrowShots {
    public static void main(String[] args) {
        findMinArrowShots(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}});
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a->a[0]));
        int count = 1;
        int leftX = points[0][0];
        int rightX = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]>rightX){
                count++;
                leftX = points[i][0];
                rightX = points[i][1];
            }else {
                if(points[i][0]==leftX&&rightX>points[i][1]){
                    rightX = points[i][1];
                }
            }
        }
        return count;
    }
}
