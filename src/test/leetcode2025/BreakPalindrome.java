package test.leetcode2025;

/**
 * 破坏回文串
 */
public class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n==1){
            return "";
        }
        int left = 0;
        int right = n-1;
        int index = n-1;
        while (left<right){
            if(palindrome.charAt(left)!='a'){
                index = left;
                break;
            }
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder(palindrome);
        sb.setCharAt(index,index==n-1?'b':'a');
        return sb.toString();
    }
}
