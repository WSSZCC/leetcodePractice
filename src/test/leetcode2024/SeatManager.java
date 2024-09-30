package test.leetcode2024;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 座位预约管理系统
 */
public class SeatManager {
    private int offset;
    private Queue<Integer> queue;
    private Map<Integer,Boolean> map;

    public SeatManager(int n) {
        queue=new PriorityQueue<>();
        map=new HashMap<>();
        offset=1;
    }

    public int reserve() {
        int poll=offset;
        if(!queue.isEmpty()){
            poll=queue.poll();
        }
        map.put(poll,true);
        offset=Math.max(offset,poll+1);
        return poll;

    }

    public void unreserve(int seatNumber) {
        if(map.containsKey(seatNumber)){
            map.put(seatNumber,false);
            queue.add(seatNumber);
        }
    }
}
