package test.leetcode2024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 与车相交的点
 */
public class NumberOfPoints {

    public int numberOfPoints(List<List<Integer>> nums) {
        int n = nums.size();
        nums.sort(Comparator.comparingInt(a->a.get(0)));
        int count = 0;
        int left = nums.get(0).get(0);
        int right = nums.get(0).get(1);
        for (int i = 0; i < n; i++) {
            List<Integer> list = nums.get(i);
            if(right<list.get(0)){
                count+=(right-left+1);
                left = list.get(0);
                right = list.get(1);
            }else {
                right = Math.max(right,list.get(1));
            }

            if(i==n-1){
                count+=(right-left+1);
            }
        }
        return count;
    }
}
