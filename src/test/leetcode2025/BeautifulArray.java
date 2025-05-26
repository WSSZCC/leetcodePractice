package test.leetcode2025;

import java.util.HashMap;

/**
 * 漂亮数组
 */
public class BeautifulArray {
    HashMap<Integer,int[]> map;
    public int[] beautifulArray(int n) {
       map = new HashMap<>();
       return  cal(n);
    }

    private int[] cal(int n) {
        int[] ints = new int[n];
        int value = 0;
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n==1){
            ints[0] = 1;
        }else {
            for (int i : cal((n + 1) / 2)) {
                ints[value++]=2*i-1;
            }
            for (int i : cal(n / 2)) {
                ints[value++] = 2*i;
            }
        }
        map.put(n,ints);
        return ints;
    }
}
