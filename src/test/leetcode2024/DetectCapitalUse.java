package test.leetcode2024;

/**
 * 检测大写字母
 */
public class DetectCapitalUse {
    public static void main(String[] args) {
        System.out.println('B'-'A');
    }
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int ascii = word.charAt(0) - 'a';
        boolean isMajuscule = ascii < 0;
        for (int i = 1; i < n; i++) {
            if(i==1&&isMajuscule&&(word.charAt(i)-'a')>=0){
                isMajuscule = false;
            }else {
                if(isMajuscule!=(word.charAt(i)-'a'<0)){
                    return false;
                }
            }
        }
        return true;
    }
}
