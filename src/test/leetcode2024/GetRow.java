package test.leetcode2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角 II
 */
public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(1));
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> preList = list.get(i);
            int n = preList.size();
            List<Integer> curList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if(j==0){
                    curList.add(preList.get(0));
                }
                if(j==n-1){
                    curList.add(preList.get(n-1));
                    break;
                }
                curList.add(preList.get(j)+preList.get(j+1));
            }
            list.add(curList);
        }
        return list.get(rowIndex);
    }
}
