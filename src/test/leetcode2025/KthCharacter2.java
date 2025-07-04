package test.leetcode2025;

/**
 * 找出第 K 个字符 II
 */
public class KthCharacter2 {
    public char kthCharacter(long k, int[] operations) {
        int count = 0;
        long flag = k-1;
        for (int operation : operations) {
            if ((flag & 1) == 1 && operation == 1) {
                count++;
            }
            flag>>=1;
        }
        count%=26;
        return (char) ('a'+count);
    }
}
