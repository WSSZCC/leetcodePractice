package test.leetcode2025;

import java.util.Arrays;

/**
 * 找出数组中的幸运数
 */
public class FindLucky {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int times = 1;
        int last = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            if(last!=arr[i]){
                if(last==times){
                    return last;
                }
                times = 1;
                last = arr[i];
            }else {
                times++;
            }
        }
        return times ==last ? times:-1;
    }
}
