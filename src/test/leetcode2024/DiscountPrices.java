package test.leetcode2024;

import java.text.DecimalFormat;

/**
 * 价格减免
 */
public class DiscountPrices {
    public static void main(String[] args) {
        discountPrices("706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6",28);

    }
    public static String discountPrices(String sentence, int discount) {
        String[] s = sentence.split(" ");
        int n = s.length;
        double discount1 = (100-discount)*0.01;
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < s.length; i++) {
            int j = s[i].length();
            if(s[i].charAt(0)=='$'&&j>1){
                int index = 1;
                while (index<j){
                    if(s[i].charAt(index)<48||s[i].charAt(index)>57){
                        break;
                    }
                    index++;
                }
                if(index==j){
                    double v = Double.parseDouble(s[i].substring(1, j)) * discount1;
                    s[i] = "$"+(v<1?"0":"")+df.format(v);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(s[0]);
        for (int i = 1; i < n; i++) {
            builder.append(" ");
            builder.append(s[i]);
        }
        return builder.toString();
    }
}
