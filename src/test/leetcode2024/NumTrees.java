package test.leetcode2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 不同的二叉搜索树
 */
public class NumTrees {
    public static void main(String[] args) {
        System.out.println(numTrees1(3));
    }


    public int numTrees(int n){
        int[] ints = new int[n + 1];
        Arrays.fill(ints,0);
        ints[0] = 1;
        ints[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ints[i] += ints[j-1]*ints[i-1];
            }
        }
        return ints[n];
    }

     static Map<Integer,Integer> map = new HashMap<>();


    public static int numTrees1(int n) {
        if(n==1||n==0){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int left = numTrees1(i-1);
            int right = numTrees1(n-i);
            count += left*right;
        }
        map.put(n,count);
        return count;
    }


}
