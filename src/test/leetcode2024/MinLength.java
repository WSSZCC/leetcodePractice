package test.leetcode2024;

/**
 * 删除子串后的字符串最小长度
 */
public class MinLength {
    public static void main(String[] args) {
        minLength("ABFCACDB");
    }

    public static int minLength(String s) {
        String s1 = "AB";
        String s2 = "CD";
        boolean isTrue = true;
        while (isTrue){
            if(!s.contains(s1) && !s.contains(s2)){
                isTrue = false;
            }
            s = s.replace(s1,"");
            s = s.replace(s2,"");
        }
        return s.length();
    }
}
