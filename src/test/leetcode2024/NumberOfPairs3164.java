package test.leetcode2024;

import java.util.HashMap;
import java.util.Map;

/**
 * 优质数对的总数 II
 */
public class NumberOfPairs3164 {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Long> map = new HashMap<>();
        for (int value : nums1) {
            if(value%k!=0){
                continue;
            }
            value/=k;
            for (int i = 1; i*i <= value; i++) {
                if(value%i!=0){
                    continue;
                }
                Long orDefault = map.getOrDefault(i, 0L);
                map.put(i,orDefault+1);
                if(i*i!=value){
                    Long orDefault1 = map.getOrDefault(value / i, 0L);
                    map.put(value/i,orDefault1+1);
                }
            }
        }
        long count =0;
        for (int i : nums2) {
            Long orDefault = map.getOrDefault(i, 0L);
            count+=orDefault;
        }
        return count;
    }
}
