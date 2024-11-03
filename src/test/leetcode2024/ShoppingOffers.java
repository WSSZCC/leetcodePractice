package test.leetcode2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 大礼包
 */
public class ShoppingOffers {
    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2,5);
        List<Integer> s1 = Arrays.asList(3,0,5);
        List<Integer> s2 = Arrays.asList(1,2,10);
        List<List<Integer>> special = Arrays.asList(s1,s2);
        List<Integer> needs = Arrays.asList(3,2);
        shoppingOffers(price,special,needs);
    }

    private static int cost=Integer.MAX_VALUE;
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> s : special) {
            int count = 0;
            int totalCost = 0;
            for (int i = 0; i < s.size()-1; i++) {
                count+=s.get(i);
                totalCost+=s.get(i)*price.get(i);
                if(count>0&&totalCost>s.get(n)){
                    list.add(s);
                    break;
                }
            }
        }
        int[] ints = new int[n + 1];
        backtrack(price,list,needs,ints);
        return cost;
    }

    private static void backtrack(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int[] ints) {
        boolean isTrue = false;
        int currentCost = 0;
        for (int i = 0; i < needs.size(); i++) {
            int count = needs.get(i) - ints[i];
            if(count<0){
                isTrue = true;
                break;
            }
            currentCost +=count*price.get(i);
        }
        if(isTrue){
            return;
        }
        cost = Math.min(currentCost+ints[ints.length-1],cost);
        for (int i = 0; i < special.size(); i++) {
            for (int j = 0; j < special.get(i).size(); j++) {
                ints[j]+=special.get(i).get(j);
            }
            backtrack(price,special,needs,ints);
            for (int j = 0; j < special.get(i).size(); j++) {
                ints[j]-=special.get(i).get(j);
            }
        }
    }
}

