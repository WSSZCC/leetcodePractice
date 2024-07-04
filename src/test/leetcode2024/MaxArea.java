package test.leetcode2024;

/**
 * 盛最多水的容器
 */
public class MaxArea {
    public static void main(String[] args) {
        maxArea(new int[]{1, 1});
    }

    public static int maxArea1(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxArea = Math.min(height[0], height[n - 1]) * (j - i);
        while (i < j) {
            if (height[i] > height[j]) {
                j--;
                if (height[j] > height[j + 1]) {
                    maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
                }
            } else {
                i++;
                if (height[i] > height[i - 1]) {
                    maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
                }
            }
        }
        return maxArea;
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxArea = 0;
        while (i < j) {
            int res = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(res, maxArea);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }

    public double findMaxAverage(int[] nums, int k) {
        int maxValue = 0;
        int temp = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            maxValue += nums[i];
            temp = maxValue;
        }
        for (int i = k; i < n; i++) {
            temp = temp + nums[i] - nums[i-k];
            maxValue = Math.max(maxValue,temp);
        }
        return 1.0*maxValue/k;
    }
}
