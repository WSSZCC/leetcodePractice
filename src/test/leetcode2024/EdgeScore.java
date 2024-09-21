package test.leetcode2024;

import java.util.HashMap;
import java.util.Map;

/**
 *  边积分最高的节点
 */
public class EdgeScore {
    public  int edgeScore(int[] edges) {
        int n = edges.length;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Long aDefault = map.getOrDefault(edges[i], 0L);
            map.put(edges[i],aDefault+i);
        }
        int minIndex = Integer.MAX_VALUE;
        long maxValue = 0;
        for (Map.Entry<Integer, Long> integerIntegerEntry : map.entrySet()) {
            Long value = integerIntegerEntry.getValue();
            if(value>=maxValue){
                int index = integerIntegerEntry.getKey();
                if(value==maxValue){
                    index = Math.min(minIndex,index);
                }
                minIndex = index;
                maxValue = value;
            }
        }
        return minIndex;
    }
}
