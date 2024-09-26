package test.leetcode2024;

/**
 * 数组元素和与数字和的绝对差
 */
public class DifferenceOfSum {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (num >= 10) {
                int value = num;
                sum += num;
                while (value > 0) {
                    sum -= (value % 10);
                    value /= 10;
                }
            }
        }
        return sum;
    }
}
