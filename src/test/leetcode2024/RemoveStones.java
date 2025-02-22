package test.leetcode2024;

import java.util.HashMap;

/**
 * 移除最多的同行或同列石头
 */
public class RemoveStones {
    public static void main(String[] args) {
        removeStones(new int[][]{{0,1},{1,0},{1,1}});
    }
    public static int removeStones(int[][] stones) {
        UnionFinds unionFind = new UnionFinds();
        int len=stones.length;
        int le=0;
        for (int[] is : stones) {
            le=unionFind.find(is);
        }
        return len-le;
    }
    private static class UnionFinds {
        private final HashMap<Integer, Integer> map;
        private final HashMap<Integer, Integer> map1;
        private int count;

        public int getCount() {
            return count;
        }
        public UnionFinds() {
            this.map = new HashMap<>();
            this.map1 = new HashMap<>();
            this.count = 0;
        }
        public int find(int [] x) {
            int y=x[0];
            int z=x[1];
            if(!(map.containsKey(y)||map1.containsKey(z))) {
                map.put(y, y);
                map1.put(z, z);
                count++;
            }else {
                map.putIfAbsent(y,y);
                map1.putIfAbsent(z, z);
            }
            return count;
        }
    }
}
