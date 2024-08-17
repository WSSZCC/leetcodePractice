package test.leetcode2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * K 周期字符串需要的最少操作次数
 */
public class MinimumOperationsToMakeKPeriodic {
    public static void main(String[] args) {
        minimumOperationsToMakeKPeriodic("leetcodeleet",4);
    }
    public static int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();
        int count = n/k;
        int index = 0;
        int maxCount = Integer.MIN_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        while (count>0){
            String s = word.substring(index, index + k);
            index+=k;
            Integer orDefault = map.getOrDefault(s, 0);
            map.put(s,orDefault+1);
            maxCount = Math.max(maxCount,orDefault+1);
            count--;
        }
        return  n/k-maxCount;
    }
}
