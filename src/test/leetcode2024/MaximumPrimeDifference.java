package test.leetcode2024;

import java.util.HashSet;
import java.util.Set;

/**
 * 质数的最大距离
 */
public class MaximumPrimeDifference {
    public static void main(String[] args) {
        maximumPrimeDifference(new int[]{});
    }

    public static int maximumPrimeDifference(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1;i<=100;i++){
            if(isPrime(i)){
                set.add(i);
            }
        }
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        boolean isLeft = false;
        boolean isRight = false;
        while (leftIndex<=rightIndex){
            if(!isLeft){
                if(set.contains(nums[leftIndex])) {
                    isLeft = true;
                } else {
                    leftIndex++;
                }
            }
            if(!isRight){
                if(set.contains(nums[rightIndex])){
                    isRight = true;
                }else {
                    rightIndex--;
                }
            }
            if(isLeft&&isRight){
                return rightIndex-leftIndex;
            }
        }
        return 0;
    }

    private static boolean isPrime(int num) {
        if(num<=1){
            return false;
        }
        for (int i = 2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
