package test.leetcode2024;

/**
 * 搜索旋转排序数组
 */
public class Search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int firstIndex = 0;
        int lastIndex = n - 1;
        int fistIndexValue = nums[0];
        if(fistIndexValue==target){
            return 0;
        }
        int lastIndexValue = nums[n-1];
        if(lastIndexValue==target){
            return n-1;
        }
        while (firstIndex <= lastIndex) {
            int mid = firstIndex+(lastIndex-firstIndex)/2;
            int value = nums[mid];
            if(value ==target){
                return mid;
            }
            if(target<lastIndexValue){
                if(value<lastIndexValue){
                    if(target<value){
                        lastIndex = mid-1;
                    }else {
                        firstIndex = mid+1;
                    }
                }else {
                   firstIndex=mid+1;
                }
            }else {
               if(value<lastIndexValue){
                   lastIndex = mid-1;
               }else {
                   if(target<value){
                       lastIndex = mid-1;
                   }else {
                       firstIndex = mid+1;
                   }
               }
            }
        }
        return -1;
    }
}
