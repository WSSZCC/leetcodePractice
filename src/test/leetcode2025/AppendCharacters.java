package test.leetcode2025;

/**
 * 追加字符以获得子序列
 */
public class AppendCharacters {
    public int appendCharacters(String s, String t) {
        int n = s.length();
        int m = t.length();
        int flag = 0;
        int flag1 = 0;
        while (flag<n&&flag1<m){
            if(s.charAt(flag) == t.charAt(flag1)){
                flag1++;
            }
            flag++;
        }
        return m-1-flag1;
    }
}
