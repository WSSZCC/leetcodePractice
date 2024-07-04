package test.leetcode2024;

/**
 * 最长回文子串
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            int targetLeft = i;
            int targetRight = n - 1;
            int count = 0;
            int flag = 1;
            while (targetLeft < targetRight) {
                if (s.charAt(targetLeft) != s.charAt(targetRight)) {
                    if (count == 0) {
                        targetRight--;
                    } else {
                        targetRight = n - 1 - flag;
                    }
                    flag++;
                    targetLeft = i;
                    count = 0;
                } else {
                    targetLeft++;
                    targetRight--;
                    count++;
                }
            }
            targetLeft = targetLeft - count;
            targetRight = targetRight + count;
            if (targetRight - targetLeft >= right - left) {
                left = targetLeft;
                right = targetRight;
            }
        }
        return s.substring(left, right + 1);
    }

    /**
     * @param s 只能通过88个用例
     * @return
     */
    public String longestPalindrome1(String s) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        if (n == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }
            return s.charAt(0) + "";
        }
        int left = 0;
        int right = 0;
        int targetLeft = 0;
        int targetRight = 0;
        for (int i = 1; i < n - 1; i++) {
            int count = Math.min(i, n - 1 - i);
            int flag = 1;
            boolean isSame = true;
            while (count > 0) {
                if (isSame) {
                    isSame = s.charAt(i) == s.charAt(i - flag) && s.charAt(i) == s.charAt(i + flag);
                }
                if (s.charAt(i - flag) != s.charAt(i + flag)) {
                    if (flag == 1) {
                        if (s.charAt(i) == s.charAt(i - flag)) {
                            targetLeft = i - flag;
                            targetRight = i;
                        }
                        if (s.charAt(i) == s.charAt(i + flag)) {
                            targetLeft = i;
                            targetRight = i + flag;
                        }
                    }
                    break;
                }
                targetLeft = i - flag;
                targetRight = i + flag;
                flag++;
                count--;
            }
            if (count == 0 && isSame) {
                if (i + flag < n && s.charAt(i) == s.charAt(i + flag)) {
                    targetRight = i + flag;
                }
            }
            if (targetRight - targetLeft >= right - left) {
                left = targetLeft;
                right = targetRight;
            }
            targetLeft = 0;
            targetRight = 0;
        }
        return s.substring(left, right + 1);
    }
}
