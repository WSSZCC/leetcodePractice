package test.leetcode2024;

/**
 * 移动零
 */
public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,4});
    }

    public static void moveZeroes1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < n; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j;i<n;i++){
            nums[i] = 0;
        }
        int k = 0;
    }
}
