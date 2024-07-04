package test.leetcode2024;

/**
 * 甲板上的战舰
 */
public class CountBattleships {
    public static void main(String[] args) {

    }

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='X'&&(i==0||board[i-1][j]!='X')&&(j==0||board[i][j-1]!='X')) {
                    res++;
                }
            }
        }
        return res;
    }
}
