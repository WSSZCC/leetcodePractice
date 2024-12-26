package test.leetcode2024;

/**
 * 字符串及其反转中是否存在同一子字符串
 */
public class IsSubstringPresent {
    public boolean isSubstringPresent(String s) {
        int n = s.length();
        for (int i = n-2; i >=0; i--) {
            String s1 = String.valueOf(s.charAt(i + 1)) + s.charAt(i);
            if(s.contains(s1)){
                return true;
            }
        }
        return false;
    }
}
