package test.leetcode2024;

import java.util.*;

/**
 * 将石头分散到网格图的最少移动次数
 */
public class MinimumMoves {
    public static void main(String[] args) {
        minimumMoves(new int[][]{{1, 2, 2}, {1, 1, 0}, {0, 1, 1}});
    }

    static int count;

    public static int minimumMoves(int[][] grid) {
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<int[]> list1 = new ArrayList<>();
        count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    list1.add(new int[]{i, j});
                }
                while (grid[i][j] > 1) {
                    list.add(new int[]{i, j});
                    grid[i][j] -= 1;
                }
            }
        }
        int n = list1.size();
        List<int[]> list2 = new ArrayList<>();
        for (int[] ints1 : list) {
            int[] ints3 = new int[n];
            for (int i = 0; i < n; i++) {
                int[] ints2 = list1.get(i);
                int length = Math.abs(ints2[0] - ints1[0]) + Math.abs(ints2[1] - ints1[1]);
                ints3[i] = length;
            }
            list2.add(ints3);
        }
        backtrack(0,list2,n,new HashSet<>(),0);

        return count;
    }

    private static void backtrack(int sum, List<int[]> list2, int n, HashSet<Integer> set,int flag) {
        if(n==flag){
            count = count==0?sum:Math.min(sum,count);
            return;
        }
        int[] ints = list2.get(flag);
        for (int i = 0; i < ints.length; i++) {
            if(!set.contains(i)){
                set.add(i);
                flag++;
                sum+=ints[i];
                backtrack(sum,list2,n,set,flag);
                flag--;
                sum-=ints[i];
                set.remove(i);
            }
        }
    }

    public static int minimumMoves1(int[][] grid) {
        int[][] ints = {{-1, 0, 0, 1}, {0, -1, 1, 0}};
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 1) {
                    for (int k = 0; k < ints[0].length; k++) {
                        if (grid[i][j] == 1) {
                            break;
                        }
                        int row = i + ints[0][k];
                        int col = j + ints[1][k];
                        if (row < 0 || row > 2 || col < 0 || col > 2) {
                            continue;
                        }
                        if (grid[row][col] == 0) {
                            grid[row][col] = 1;
                            grid[i][j] -= 1;
                            count++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    boolean[][] booleans = new boolean[3][3];
                    for (boolean[] aBoolean : booleans) {
                        Arrays.fill(aBoolean, false);
                    }
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    booleans[i][j] = true;
                    while (!queue.isEmpty()) {
                        boolean isFind = false;
                        int[] poll = queue.poll();
                        for (int k = 0; k < ints[0].length; k++) {
                            int row = poll[0] + ints[0][k];
                            int col = poll[1] + ints[1][k];
                            if (row < 0 || row > 2 || col < 0 || col > 2 || booleans[row][col]) {
                                continue;
                            }
                            if (grid[row][col] > 1) {
                                grid[row][col] -= 1;
                                grid[i][j] = 1;
                                count += Math.abs(row - i) + Math.abs(col - j);
                                isFind = true;
                                break;
                            }
                            booleans[row][col] = true;
                            queue.add(new int[]{row, col});
                        }
                        if (isFind) {
                            break;
                        }
                    }
                    grid[i][j] -= 1;
                }
            }
        }
        return count;
    }
}
