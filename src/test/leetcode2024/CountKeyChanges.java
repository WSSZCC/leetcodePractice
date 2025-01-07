package test.leetcode2024;

/**
 * 按键变更的次数
 */
public class CountKeyChanges {
    public int countKeyChanges(String s) {
        int count=0;
        char pre = s.charAt(0);
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int a = Math.abs(chars[i]-pre);
            if(a!=32&&a!=0){
                count++;
            }
            pre = chars[i];
        }
        return count;
    }
}
