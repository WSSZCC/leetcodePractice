package test.leetcode2024;

/**
 * 交换后字典序最小的字符串
 */
public class GetSmallestString3216 {
    public String getSmallestString(String s) {
        int n = s.length();
        char pre = s.charAt(0);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < n; i++) {
            char cur = s.charAt(i);
            if(pre-cur>0&&((pre-cur)&1)==0){
                sb.setCharAt(i-1,cur);
                sb.setCharAt(i,pre);
                break;
            }
            pre = cur;
        }
        return sb.toString();
    }
}
