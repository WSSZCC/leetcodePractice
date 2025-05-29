package test.leetcode2025;

/**
 * 改变一个整数能得到的最大差值
 */
public class MaxDiff {
    public static void main(String[] args) {
       System.out.println(maxDiff(111));
    }
    public static int maxDiff(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] < '9') {
                int index = i + 1;
                char c = chars[i];
                chars[i] = '9';
                while (index < s.length()) {
                    if (chars[index] == c) {
                        chars[index] = '9';
                    }
                    index++;
                }
                break;
            }
        }
        char[] chars1 = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 && chars1[i] != '1')||(i>0&&chars1[i] != '0'&&chars1[i] != '1')) {
                char c = chars1[i];
                char value = i==0?'1':'0';
                chars1[i] = value;
                int index = i + 1;
                while (index<s.length()){
                    if(chars1[index]==c){
                        chars1[index] = value;
                    }
                    index++;
                }
                break;
            }
        }
        return Integer.parseInt(new String(chars)) - Integer.parseInt(new String(chars1));
    }
}
