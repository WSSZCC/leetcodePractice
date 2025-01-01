package test.leetcode2024;

/**
 * 将日期转换为二进制表示
 */
public class ConvertDateToBinary {
    public String convertDateToBinary(String date) {
        return stringToBinary(date.substring(0,4))+"-"+stringToBinary(date.substring(5,7))
                +"-"+stringToBinary(date.substring(8,10));
    }

    private String stringToBinary(String s) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        int value = 0;
        if(s.charAt(0)=='0'){
            value = Integer.parseInt(s.substring(1,2));
        }else {
            value = Integer.parseInt(s);
        }
        while ((1<<flag)<value){
            flag++;
        }

        for (int i = flag; i >= 0; i--) {
            if(value>=(1<<i)){
                sb.append("1");
                value -= (1<<i);
            }else {
                if(i!=flag){
                    sb.append("0");
                }
            }
        }
        return sb.toString();
    }
}
