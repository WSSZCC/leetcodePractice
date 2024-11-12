package test.leetcode2024;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU (最近最少使用) 缓存
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }


    //做不到o(1)
//    private Map<Integer, Integer> map;
//    private LinkedList<Integer> list;
//    private int maxCapacity;
//    public LRUCache(int capacity) {
//        map = new HashMap<>();
//        list = new LinkedList<>();
//        maxCapacity = capacity;
//
//    }
//
//    public int get(int key) {
//        Integer orDefault = map.getOrDefault(key, -1);
//        if(orDefault!=-1){
//            list.remove((Object)key);
//            list.add(key);
//        }
//        return orDefault;
//    }
//
//    public void put(int key, int value) {
//        Integer orDefault = map.getOrDefault(key, -1);
//        if(orDefault!=-1){
//            list.remove((Object)key);
//        }
//        if(list.size()>=maxCapacity){
//            map.remove(list.peekFirst());
//            list.pollFirst();
//        }else {
//            list.add(key);
//        }
//        map.put(key, value);
//    }
}
