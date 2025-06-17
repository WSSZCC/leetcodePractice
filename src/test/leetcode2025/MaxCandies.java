package test.leetcode2025;

import java.util.Arrays;
import java.util.LinkedList;

public class MaxCandies {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] booleans = new boolean[n];
        Arrays.fill(booleans,false);
        LinkedList<Integer> list = new LinkedList<>();
        for (int initialBox : initialBoxes) {
            list.addLast(initialBox);
        }
        int[] ints = new int[n];
        int ans = 0;
        while (!list.isEmpty()){
            Integer integer = list.pollFirst();
            if(!booleans[integer]){
                booleans[integer] = true;

            }
        }
        return 0;
    }
}
