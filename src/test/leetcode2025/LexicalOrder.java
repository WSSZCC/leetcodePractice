package test.leetcode2025;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典序排数
 */
public class LexicalOrder {
    List<Integer> list;
    public List<Integer> lexicalOrder(int n) {
        list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i,n);
        }
        return list;
    }

    private void dfs(int i, int max) {
        if(i>max){
            return;
        }
        list.add(i);
        for (int j = 0; j <= 9; j++) {
            dfs(i*10+j,max);
        }
    }
}
