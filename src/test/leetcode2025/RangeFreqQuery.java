package test.leetcode2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class RangeFreqQuery {
    Map<Integer, List<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i],list);
        }
        map.forEach((k,v)->{
            v.sort(Integer::compareTo);
        });
    }

    public int query(int left, int right, int value) {
        if(map.containsKey(value)){
            List<Integer> list = map.get(value);
            int left1 = 0;
            int right1= list.size()-1;
            while (left1<=right1){
                int mid = left1+(right1-left1)/2;
                if(list.get(mid)<left){
                    left1=mid+1;
                }else {
                    right1=mid-1;
                }
            }
            int left2 = 0;
            int right2= list.size()-1;
            while (left2<=right2){
                int mid = left2+(right2-left2)/2;
                if(list.get(mid)<=right){
                    left2=mid+1;
                }else {
                    right2=mid-1;
                }
            }
            return left2-left1;
        }
        return 0;
    }
}
