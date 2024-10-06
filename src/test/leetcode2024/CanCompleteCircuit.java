package test.leetcode2024;

/**
 * 加油站
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int beginIndex =-1;
        long preSum = 0;
        long currentSum = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int value = gas[i] - cost[i];
            currentSum+=value;
            if(currentSum<0){
                preSum+=currentSum;
                currentSum=0;
                beginIndex = i;
            }
        }
       return preSum+currentSum<0?-1:beginIndex+1;
    }
}
