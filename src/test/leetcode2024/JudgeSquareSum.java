package test.leetcode2024;

/**
 * 平方数之和
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        judgeSquareSum(8);
    }
    public static boolean judgeSquareSum(int c) {
        long max = Math.round(Math.sqrt(c));
        for (long i = max; i >0; i--) {
            long round = Math.round(Math.sqrt(c - i * i));
            if(round*round+i*i==c){
                return true;
            }
        }
        return false;
    }
}
