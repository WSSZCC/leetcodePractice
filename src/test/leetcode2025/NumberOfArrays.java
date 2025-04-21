package test.leetcode2025;

/**
 *  统计隐藏数组数目
 */
public class NumberOfArrays {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        long pre = lower;
        long pre1 = upper;
        for (int difference : differences) {
            pre+=difference;
            pre1+=difference;
            min= Math.min(min,pre);
            max = Math.max(max,pre1);
        }
        if(min>upper||max<lower){
            return 0;
        }
        if(min>=lower){
            min = lower;
        }
        if(max<=upper){
            max = upper;
        }
        return (int) Math.max(2*upper-max-2*lower+min+1,0);
    }
}
