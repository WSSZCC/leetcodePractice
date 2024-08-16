package test.leetcode2024;

/**
 * 外观数列
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        if(n==1){
            return s;
        }
        int i = 1;
        while (i<n){
            StringBuilder sb = new StringBuilder();
            char c = ' ';
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if(j==0){
                    count = 1;
                    c = s.charAt(j);
                }else {
                    if (s.charAt(j) == c) {
                        count++;
                    } else {
                        sb.append(count).append(c);
                        count = 1;
                        c = s.charAt(i);
                    }
                }
                if(j==s.length()-1){
                    sb.append(count).append(c);
                }
            }
            s =sb.toString();
            i++;
        }
        return s;
    }
}
