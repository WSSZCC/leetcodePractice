package test.leetcode2024;

import java.util.HashMap;
import java.util.Map;

/**
 * 我的日程安排表 III
 */
public class MyCalendarThree {
    Map<Integer,int[]> map;
    public MyCalendarThree() {
        map = new HashMap<>();
    }

    public int book(int startTime, int endTime) {
      update(startTime,endTime-1,1,0,1000000000,1);
      map.putIfAbsent(1,new int[2]);
      return map.get(1)[0];
    }

    private void update(int startTime, int endTime, int value, int a, int b, int index) {
        if(b<startTime||endTime<a){
            return;
        }
        map.putIfAbsent(index,new int[2]);
        if(startTime<=a&&b<=endTime){
            map.get(index)[0]+=value;
            map.get(index)[1]+=value;
        }else {
            int mid = (a+b)>>1;
            update(startTime,endTime,value,a,mid,2*index);
            update(startTime,endTime,value,mid+1,b,2*index+1);
            map.putIfAbsent(2*index,new int[2]);
            map.putIfAbsent(2*index+1,new int[2]);
            map.get(index)[0] = map.get(index)[1]+Math.max(map.get(2*index)[0],map.get(2*index+1)[0]);
        }
    }

}
