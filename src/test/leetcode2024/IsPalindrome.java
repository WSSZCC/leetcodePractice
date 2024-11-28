package test.leetcode2024;

/**
 * 回文字数
 */
public class IsPalindrome {
    public boolean isPalindrome(int k){
        String s = k+"";
        int n = s.length();
        int left = 0;
        int right = n-1;
        while (left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
