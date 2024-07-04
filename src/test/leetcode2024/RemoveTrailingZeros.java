package test.leetcode2024;

/**
 * 移除字符串中的尾随零
 */
public class RemoveTrailingZeros {
    public static void main(String[] args) {
        String s = "100001";
        System.out.println(s.substring(0,5));
    }
    public String removeTrailingZeros(String num) {
        int n = num.length();
        int index = 0;
        for (int i = n-1; i >= 0; i--) {
            if(num.charAt(i)!='0'){
                break;
            }
            index = i;
        }
        return num.substring(0,index+1);
    }
}
