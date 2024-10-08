package test.leetcode2024;

import java.util.*;

/**
 * 旅行终点站
 */
public class DestCity {
    public String destCity(List<List<String>> paths) {
        Set<String> preSet = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            if(preSet.contains(path.get(1))){
                preSet.remove(path.get(1));
            }else {
                set.add(path.get(1));
            }
            if(set.contains(path.get(0))){
                set.remove(path.get(0));
            }else {
                preSet.add(path.get(0));
            }
        }
        return set.stream().findFirst().orElse("");
    }
}
