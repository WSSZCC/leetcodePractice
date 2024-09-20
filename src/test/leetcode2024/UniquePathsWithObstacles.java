package test.leetcode2024;

/**
 * 不同路径 II
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1||obstacleGrid[n-1][m-1]==1){
            return 0;
        }
        int[][] ints = {{0, 1}, {1, 0}};
        obstacleGrid[0][0]=-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(obstacleGrid[i][j]==1){
                    continue;
                }
                for (int[] anInt : ints) {
                    int x = anInt[0]+i;
                    int y = anInt[1]+j;
                    if(x>=n||y>=m||obstacleGrid[x][y]==1){
                        continue;
                    }
                    obstacleGrid[x][y]+=obstacleGrid[i][j];
                }
            }
        }
        return obstacleGrid[n-1][m-1];
    }
}
