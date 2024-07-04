package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 *组合总和 III
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        combinationSum3(3,9);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n,k,0,new ArrayList<>(),result);
        return result;
    }

    public static void backtrack(int num, int target, int start, List<Integer> subset, List<List<Integer>> result) {
        if (start == target) {
            if (num == 0) {
                result.add(new ArrayList<>(subset));
            }
            return;
        }
        int firstValue = start==0?1:subset.get(start-1)+1;
        for (int i = firstValue; i <= 9; i++) {
            if(!subset.contains(i)) {
                num -= i;
                subset.add(i);
                backtrack(num, target, ++start, subset, result);
                subset.remove(subset.size() - 1);
                start--;
                num += i;
            }
        }
    }
}
