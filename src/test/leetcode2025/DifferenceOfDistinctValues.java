package test.leetcode2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 对角线上不同值的数量差
 */
public class DifferenceOfDistinctValues {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int len = m+n-1;
        List<Integer>[] lists = new ArrayList[len];
        Arrays.setAll(lists,i->new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lists[n-i+j].add(grid[i][j]);
            }
        }
        int[][] ints = new int[n][m];
        int row=n-1;
        int col=0;
        for (int i = 0; i < len; i++) {
            int x=row;
            int y=col;
            List<Integer> list = lists[i];
            int size = list.size();
            int[] ints1 = new int[size];
            Arrays.fill(ints1,0);
            HashSet<Integer> set = new HashSet<>();
            for (int j = size-1; j >=0; j--) {
                set.add(list.get(j));
                ints1[j]=set.size();
            }
            set.clear();
            for (int j = 0; j < size-1; j++) {
                ints[x][y]=Math.abs(set.size()-ints1[j+1]);
                set.add(list.get(j));
                x++;
                y++;
            }
            ints[x][y]=set.size();
            if(row==0){
                col++;
            }else {
                row--;
            }
        }
        return ints;
    }
}
