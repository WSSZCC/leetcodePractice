package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 双模幂运算
 */
public class GetGoodIndices {
    public static void main(String[] args) {
        System.out.println(3>>1);
        getGoodIndices(new int[][]{{2,3,3,10},{3,3,3,1},{6,1,1,4}},2);
    }
    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] variable = variables[i];
            long res = powMod( (powMod(variable[0],variable[1],10)),variable[2],variable[3]);
            if(res==target){
                list.add(i);
            }
        }
        return list;
    }
    public static int powMod(int base, int exponent,int mod) {
        int ans = 1;
        while (exponent>0){
            ans = (ans*(base%mod))%mod;
            exponent--;
        }
        return ans;
    }
}
