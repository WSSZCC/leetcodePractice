package test.leetcode2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 将整数按权重排序
 */
public class GetKth {

    Map<Integer,Integer> map;
    public int getKth(int lo, int hi, int k) {
        int[][] ints = new int[hi - lo + 1][2];
        map = new HashMap<>();
        map.put(1,1);
        int index = -1;
        for (int i = lo; i <= hi; i++) {
            index++;
            if(map.containsKey(i)){
                ints[index] = new int[]{map.get(i),i};
                continue;
            }
            ints[index] = new int[]{dfs(i),i};
        }
        Arrays.sort(ints, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });
        return ints[k-1][1];
    }

    private int dfs(int i) {
        if(map.containsKey(i)){
            return map.get(i);
        }
        int value = 0;
        if(i%2==0){
            value = dfs(i/2)+1;
        }else {
            value = dfs(i*3+1)+1;
        }
        map.put(i,value);
        return value;
    }
}
