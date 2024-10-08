package test.leetcode2024;

import java.util.HashSet;
import java.util.Set;

/**
 * 单词搜索
 */
public class Exist {
    private static boolean isTrue;
    private static int n;
    private static int m;
    private static int[][] ints = new int[][]{{1,-1,0,0},{0,0,1,-1}};

    public static void main(String[] args) {
        exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"SEE");
    }
    public static boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        int len = word.length();
        isTrue = false;
        if(n*m<len){
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]==word.charAt(0)){
                    if(len==1){
                        isTrue=true;
                        break;
                    }else {
                        Set<String> set = new HashSet<>();
                        set.add(i+","+j);
                        backtrack(i, j,1,len,set,word,board);
                        if(isTrue){
                            break;
                        }
                    }
                }
            }
        }
        return isTrue;
    }

    private static void backtrack(int i, int j, int index, int len, Set<String> set, String word, char[][] board) {
        if(index==len){
            isTrue=true;
            return;
        }
        for (int k=0;k<4;k++) {
            int x = i + ints[0][k];
            int y = j + ints[1][k];
            if (x < 0 || x >= n || y < 0 || y >= m || set.contains(x + "," + y)) {
                continue;
            }
            if (board[x][y] == word.charAt(index)) {
                set.add(x + "," + y);
                index++;
                backtrack(x, y, index, len, set, word, board);
                set.remove(x + "," + y);
                index--;
            }
            if (isTrue) {
                break;
            }
        }
    }
}
