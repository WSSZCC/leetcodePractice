package test.leetcode2024;

/**
 * 执行子串操作后的字典序最小字符串
 */
public class SmallestString {
    public static void main(String[] args) {
        smallestString("acbbc");
    }
    public static String smallestString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        boolean isChange = false;
        for (int i = 0; i < n; i++) {
            if(isChange&&(sb.charAt(i)=='a')){
                break;
            }
            if(sb.charAt(i)!='a'){
                char ch = (char) (sb.charAt(i) - 1);
                sb.setCharAt(i,ch);
                isChange = true;
            }
        }
        return sb.toString();
    }
}
