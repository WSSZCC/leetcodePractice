package test.leetcode2025;

/**
 *
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        int flag = 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (flag == 0) {
                    return false;
                }
                flag--;
                if (s.charAt(left) == s.charAt(right - 1) && s.charAt(left + 1) == s.charAt(right)) {
                    break;
                }
                if (s.charAt(left) == s.charAt(right - 1)) {
                    right--;
                } else {
                    left++;
                    continue;
                }
            }
            left++;
            right--;
        }
        int left1 = left + 1;
        int right1 = right - 1;
        boolean isTrue1 = true;
        while (left1 < right) {
            if (s.charAt(left1) != s.charAt(right)) {
                isTrue1 = false;
                break;
            }
            left1++;
            right--;
        }
        boolean isTrue2 = true;
        while (left < right1) {
            if (s.charAt(left) != s.charAt(right1)) {
                isTrue2 = false;
                break;
            }
            left++;
            right1--;
        }

        return isTrue1 || isTrue2;
    }
}
