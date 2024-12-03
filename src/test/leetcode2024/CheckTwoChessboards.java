package test.leetcode2024;

/**
 * 检查棋盘方格颜色是否相同
 */
public class CheckTwoChessboards {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int value1 = coordinate1.charAt(0) - coordinate2.charAt(0);
        int value2 = coordinate1.charAt(1) - coordinate2.charAt(1);
        return (Math.abs(value1)%2==0&&Math.abs(value2)%2==0)||(Math.abs(value1)%2==1&&Math.abs(value2)%2==1);
    }
}
