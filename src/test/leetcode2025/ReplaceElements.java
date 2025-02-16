package test.leetcode2025;

import java.util.Arrays;

/**
 * 1299. 将每个元素替换为右侧最大元素
 */
public class ReplaceElements {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] ints = new int[n];
        Arrays.fill(ints,-1);
        for (int i = n-2; i >=0; i--) {
            ints[i]=Math.max(ints[i+1],arr[i+1]);
        }
        return arr;
    }
}
