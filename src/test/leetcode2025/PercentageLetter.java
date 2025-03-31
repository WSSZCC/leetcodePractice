package test.leetcode2025;

/**
 * 字母在字符串中的百分比
 */
public class PercentageLetter {
    public int percentageLetter(String s, char letter) {
        int length = s.length();
        int count = 0;
        for (char c : s.toCharArray()) {
            if(c==letter){
                count++;
            }
        }
        return count*100/length;
    }
}
