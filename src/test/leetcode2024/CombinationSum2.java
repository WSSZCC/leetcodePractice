package test.leetcode2024;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 组合总和 II
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        dfs(n, 0, 0, candidates, target, new ArrayList<>(), list);
        return list;
    }

    private void dfs(int n, int index, int sum, int[] candidates, int target, List<Integer> list, List<List<Integer>> targetList) {
        if (sum == target) {
            targetList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < n; i++) {
            if (i > index && candidates[i - 1] == candidates[i]) continue;
            sum += candidates[i];
            if (sum <= target) {
                list.add(candidates[i]);
                dfs(n, i + 1, sum, candidates, target, list, targetList);
                sum -= candidates[i];
                list.remove(list.size() - 1);
            } else {
                break;
            }
        }
    }
}
