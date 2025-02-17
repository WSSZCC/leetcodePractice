package test.leetcode2025;

/**
 * 有序数组中出现次数超过25%的元素
 */
public class FindSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int pre = arr[0];
        if(n==1){
            return arr[0];
        }
        int count = 1;

        for (int i = 1; i < n; i++) {
            if(arr[i]!=pre){
                if(n<count*4){
                    return pre;
                }
                count = 0;
            }
            count++;
            pre = arr[i];
        }
        if(n<count*4){
            return pre;
        }
        return -1;
    }
}
