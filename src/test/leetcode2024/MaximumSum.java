package test.leetcode2024;

/**
 * 删除一次得到子数组最大和
 */
public class MaximumSum {
    public static void main(String[] args) {
        maximumSum(new int[]{1, -2, 0, 3});
    }

    /**
     * @param arr
     * @return
     * 有超时风险
     */
    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int ansMax = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                break;
            }
            if (i > 0) {
                ansMax += arr[i];
            }
        }
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                int currentMax = preSum;
                for (int j = i + 1; j < n; j++) {
                    currentMax += arr[j];
                    ansMax = Math.max(ansMax, currentMax);
                    if (currentMax < 0) {
                        currentMax = 0;
                    }
                }
            }
            preSum += arr[i];
            if (preSum < 0) {
                preSum = 0;
            }

        }
        return ansMax;
    }
}
