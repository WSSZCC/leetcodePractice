package test.leetcode2025;

/**
 * 检查平衡字符串
 */
public class IsBalanced {
    public boolean isBalanced(String num) {
        int sum=0;
        int flag = 1;
        for (char c : num.toCharArray()) {
            sum +=flag*(c-'0');
            flag*=-1;
        }
        return sum==0;
    }
}
