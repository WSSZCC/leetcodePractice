package test.leetcode2024;

/**
 * 可以被一步捕获的棋子数
 */
public class NumRookCaptures {
    public int numRookCaptures(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 'R'){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int ans =0;
        for (int i = x-1;i>=0;i--){
            if(board[i][y]=='B'||board[i][y]=='p'){
              if(board[i][y]=='p'){
                  ans++;
              }
                break;
            }
        }
        for (int i = x+1; i < n; i++) {
            if(board[i][y]=='B'||board[i][y]=='p'){
                if(board[i][y]=='p'){
                    ans++;
                }
                break;
            }
        }

        for (int i = y-1;i>=0;i--){
            if(board[x][i]=='B'||board[x][i]=='p'){
                if(board[x][i]=='p'){
                    ans++;
                }
                break;
            }
        }
        for (int i = y+1; i < n; i++) {
            if(board[x][i]=='B'||board[x][i]=='p'){
                if(board[x][i]=='p'){
                    ans++;
                }
                break;
            }
        }

        return ans;

    }
}
