package test.leetcode2024;

import java.util.Arrays;

/**
 * 字符串相乘
 */
public class Multiply {
    public static void main(String[] args) {
        multiply("123","456");
    }
    public static String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        if (num1.equals("1")) {
            return num2;
        }
        if (num2.equals("1")) {
            return num1;
        }
        int[] ints = new int[n + m + 1];
        Arrays.fill(ints,0);
        int flag1 = 0;
        for (int i = n - 1; i >= 0; i--) {
            int flag2 = 0;
            int numValue1 = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int numValue2 = (num2.charAt(j) - '0') * numValue1;
                int sum = ints[flag1 + flag2] + numValue2;
                if(sum<10){
                    ints[flag1+flag2] = sum;
                }else {
                    int flag3 = 0;
                    while (sum>=10){
                        ints[flag1+flag2+flag3] = sum%10;
                        sum = ints[flag1+flag2+flag3+1] +sum/10;
                        flag3++;
                    }
                    if(sum!=0){
                        ints[flag1+flag2+flag3] = sum;
                    }
                }
                flag2++;
            }
            flag1++;
        }
        StringBuilder sb = new StringBuilder();
        int index = ints.length-1;
        for (int i = ints.length-1;i>=0;i--){
            if(ints[i]!=0){
                index = i;
                break;
            }
        }
        for (int i = index; i >= 0; i--) {
            sb.append(ints[i]);
        }
        return sb.toString();
    }
}
