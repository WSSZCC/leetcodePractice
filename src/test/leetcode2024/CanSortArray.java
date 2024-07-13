package test.leetcode2024;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一个数组是否可以变为有序
 */
public class CanSortArray {
    public static void main(String[] args) {
        canSortArray(new int[]{75,34,30});
    }
    public static boolean canSortArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            map.computeIfAbsent(num, CanSortArray::getCountOnes);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if(nums[j]>nums[j+1]&& map.get(nums[j]).equals(map.get(nums[j + 1]))){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < n-1; i++) {
          if(nums[i]>nums[i+1]){
              return false;
          }
        }
        return true;

    }

    private static int getCountOnes(int num) {
        int count = 0;
        while (num>0){
            count +=num&1;
            num>>>=1;
        }
        return count;
    }
}
