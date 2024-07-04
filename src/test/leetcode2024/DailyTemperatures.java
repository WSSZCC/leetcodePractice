package test.leetcode2024;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日温度
 */
public class DailyTemperatures {
    public static void main(String[] args) {

    }

    /**
     * @param temperatures 会超时
     * @return
     */
    public static int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] ints = new int[n];
        ints[n-1] = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(temperatures[j]-temperatures[i]>0){
                    ints[i] = j-i;
                    break;
                }
            }
        }
        return ints;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ints = new int[n];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int data = temperatures[i];
            while(!list.isEmpty()&&data>temperatures[list.peek()]){
                Integer index = list.pop();
                ints[index] = i-index;
            }
            list.push(i);
        }
        return ints;
    }
}
