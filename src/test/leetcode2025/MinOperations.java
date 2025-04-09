package test.leetcode2025;

import java.util.HashSet;

/**
 * 使数组的值全部为 K 的最少操作次数
 */
public class MinOperations {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(num<k){
                return -1;
            }
            if(num>k){
                set.add(num);
            }
        }
        return set.size();
    }
}
