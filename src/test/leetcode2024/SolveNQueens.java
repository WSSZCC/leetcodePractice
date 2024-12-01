package test.leetcode2024;

import java.util.*;

/**
 * N 皇后
 */
public class SolveNQueens {
     boolean[][] booleans;
     Set<Integer> set;
     List<List<String>> ansList;

    public  List<List<String>> solveNQueens(int n) {
        List<String> list = new ArrayList<>();
        ansList = new ArrayList<>();
        booleans = new boolean[n][n];
        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            sb.setCharAt(i,'Q');
            list.add(sb.toString());
            Arrays.fill(booleans[i],false);
        }
        backtrack(0,n,list,new ArrayList<>());
        return ansList;
    }

    private  void backtrack(int row, int n, List<String> list, List<String> targetList) {
       if(set.size()==n){
           ansList.add(new ArrayList<>(targetList));
           return;
       }
        for (int i = 0; i < n; i++) {
            if(set.contains(i)||booleans[row][i]){
                continue;
            }
            set.add(i);
            targetList.add(list.get(i));
            Set<String> tempSet = new HashSet<>();
            for (int j = row+1; j < n; j++) {
                if(booleans[j][i]){
                    tempSet.add(j+""+i);
                    continue;
                }
                booleans[j][i]=true;
            }
            for (int j = 0; j < i; j++) {
                if(i-j+row>=n){
                    continue;
                }
                if(booleans[i-j+row][j]){
                    tempSet.add((i-j+row)+""+j);
                    continue;
                }
                booleans[i-j+row][j]=true;
            }
            int x= row;
            for (int j = i+1; j < n; j++) {
                x++;
                if(x>=n){
                    break;
                }
                if(booleans[x][j]){
                    tempSet.add(x+""+j);
                    continue;
                }
                booleans[x][j] = true;
            }
            backtrack(row+1,n,list,targetList);
            for (int j = row+1; j < n; j++) {
                if(tempSet.contains(j+""+i)){
                    continue;
                }
                booleans[j][i]=false;
            }
            for (int j = 0; j < i; j++) {
                if(i-j+row>=n||tempSet.contains((i-j+row)+""+j)){
                    continue;
                }
                booleans[i-j+row][j]=false;
            }
            int x1= row;
            for (int j = i+1; j < n; j++) {
                x1++;
                if(x1>=n){
                    break;
                }
                if(tempSet.contains(x1+""+j)){
                    continue;
                }
                booleans[x1][j] = false;
            }
            set.remove(i);
            targetList.remove(targetList.size()-1);
        }
    }
}
