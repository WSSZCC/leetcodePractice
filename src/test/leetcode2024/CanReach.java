package test.leetcode2024;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 跳跃游戏 III
 */
public class CanReach {
    public static void main(String[] args) {
        canReach(new int[]{58,48,64,36,19,19,67,13,32,2,59,50,29,68,50,0,69,31,54,20,22,43,30,9,68,71,20,22,48,74,2,65,27,54,30,5,66,24,64,68,9,31,50,59,15,72,6,49,11,71,12,61,5,66,30,1,2,39,59,35,53,21,76,17,71,40,68,57,64,53,70,21,50,49,25,63,35},46);
    }
    public static boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if(arr[start]==0){
            return true;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] booleans = new boolean[n];
        int[] ints = {-1, 1};
        Arrays.fill(booleans,false);
        queue.add(start);
        booleans[start] = true;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            for (int anInt : ints) {
                int index = poll+(arr[poll]*anInt);
                if(index<0||index>=n|| booleans[index]){
                    continue;
                }
                if(arr[index]==0){
                    return true;
                }
                queue.add(index);
                booleans[index] = true;
            }
        }
        return false;
    }
}
