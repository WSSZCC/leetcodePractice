package test.leetcode2025;

/**
 *  替换一个数字后的最大差值
 */
public class MinMaxDifference {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        char[] chars = s.toCharArray();
        char aChar = chars[0];
        char aChar1 = chars[0];
        int index = 0;
        boolean isTrue = false;
        for (int i = 0; i < n; i++) {
            if(chars[i]!='9'&&!isTrue){
                isTrue = true;
                aChar1 = chars[i];
                index = i;
            }
            if(chars[i]==aChar){
                chars[i]='0';
            }
        }
        char[] chars1 = s.toCharArray();
        for (int i = index; i < n; i++) {
            if(aChar1==chars1[i]){
                chars1[i]= '9';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(chars[i]==0&&sb.length()==0){
                continue;
            }
            sb.append(chars[i]);
        }
        return Math.abs(Integer.parseInt(new String(chars1))-(sb.length()==0?0:Integer.parseInt(sb.toString())));
    }
}
