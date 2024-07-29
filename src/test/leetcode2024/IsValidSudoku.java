package test.leetcode2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有效的数独
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}});
    }
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> houseMap = new HashMap<>();
        houseMap.put(0,new HashSet<>());
        houseMap.put(1,new HashSet<>());
        houseMap.put(2,new HashSet<>());
        int flag = 0;
        for (int i = 0; i < 9; i++) {
            if(i/3>flag){
                flag++;
                houseMap.put(0,new HashSet<>());
                houseMap.put(1,new HashSet<>());
                houseMap.put(2,new HashSet<>());
            }
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    // 行
                    if (rowSet.contains(c)) {
                        return false;
                    }
                    rowSet.add(c);
                    // 列
                    Set<Character> colSet = colMap.getOrDefault(j, new HashSet<>());
                    if (colSet.contains(c)) {
                        return false;
                    }
                    colSet.add(c);
                    colMap.put(j, colSet);
                    // 宫
                    int houseKey = j / 3;
                    Set<Character> houseSet = houseMap.get(houseKey);
                    if(houseSet.contains(c)){
                        return false;
                    }
                    houseSet.add(c);
                    houseMap.put(houseKey,houseSet);

                }
            }
            rowSet = new HashSet<>();
        }
        return true;
    }
}
