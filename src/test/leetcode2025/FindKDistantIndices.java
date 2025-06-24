package test.leetcode2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 找出数组中的所有 K 近邻下标
 */
public class FindKDistantIndices {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(nums[i]==key){
                for (int j = Math.max(0,i-k); j < Math.min(n,i+k); j++) {
                    set.add(j);
                }
            }
        }
        List<Integer> integers = new ArrayList<>(set);
        Collections.sort(integers);
        return integers;
    }
}
