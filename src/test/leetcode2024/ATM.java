package test.leetcode2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 设计一个 ATM 机器
 */
public class ATM {
    Map<Integer,Integer> map;
    int[] ints;
    public ATM() {
        map = new HashMap<>();
        map.put(0,20);
        map.put(1,50);
        map.put(2,100);
        map.put(3,200);
        map.put(4,500);
        ints = new int[5];
        Arrays.fill(ints,0);
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            ints[i]+=banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int index = 4;
        int[] ints1 = new int[5];
        Arrays.fill(ints1,0);
        while (index>=0&&(amount%10)==0){
            int i = amount / map.get(index);
            if(i>0){
              ints1[index]=Math.min(i,ints[map.get(index)]);
              amount-=ints1[index]*map.get(index);
            }
            index--;
        }
        if(amount>0){
            Arrays.fill(ints1,0);
        }
        for (int i = 0; i < ints1.length; i++) {
            ints[i]-=ints1[i];
        }
        return ints1;
    }
}
