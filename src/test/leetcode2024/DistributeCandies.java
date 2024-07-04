package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 给小朋友们分糖果 I
 */
public class DistributeCandies {
    public static void main(String[] args) {
        distributeCandies(5,2);
    }

    public static int distributeCandies(int n, int limit) {
        int[] ints = {0};
        backtrack(n,3,0,ints,limit);
        return ints[0];
    }

    public static void backtrack(int sum,int target,int start,int[] count,int limit) {
        if(target==start){
            if(sum==0){
                count[0] = count[0]+1;
            }
            return;
        }
        for (int i = 0; i <= limit; i++) {
            sum-=i;
            backtrack(sum,target,++start,count,limit);
            start--;
            sum+=i;
        }
    }
}
