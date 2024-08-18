package test.leetcode2024;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] ints = {-1, -1};
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int mid = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[mid] < target) {
                leftIndex = mid + 1;
            } else {
                if (nums[mid] == target) {
                    ints[0] = mid;
                }
                rightIndex = mid - 1;
            }
        }
        leftIndex = 0;
        rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int mid = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    ints[1] = mid;
                }
                leftIndex = mid + 1;
            } else {
                rightIndex = mid - 1;
            }
        }
        return ints;
    }
}
