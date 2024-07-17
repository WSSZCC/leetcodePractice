package test.leetcode2024;

import java.util.Arrays;

/**
 * 最接近的三数之和
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
    }

    /**
     * @param nums
     * @param target
     * @return
     * 先解决有没有
     */
    public  int threeSumClosest1(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int minValue = target - nums[0] - nums[1] - nums[2];
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                for (int third = second + 1; third < n; third++) {
                    int value = target - nums[first] - nums[second] - nums[third];
                    if (value == 0) {
                        return target;
                    }
                    if(value<0){
                        if(Math.abs(value)<Math.abs(minValue)){
                            minValue = value;
                        }
                    }else {
                        minValue = Math.min(value,Math.abs(minValue));
                    }
                }
            }
        }
        return target-minValue;
    }
}
