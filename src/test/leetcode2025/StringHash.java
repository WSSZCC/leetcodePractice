package test.leetcode2025;

/**
 * 哈希分割字符串
 */
public class StringHash {
    public String stringHash(String s, int k) {
        int n = s.length();
        char[] chars = new char[n / k];
        int flag = k;
        int sum = 0;
        int index = 0;
        for (char c : s.toCharArray()) {
            sum+=c-'a';
            flag--;
            if(flag==0){
                chars[index] = (char) (sum%26+'a');
                index++;
                sum=0;
                flag = k;
            }
        }
        return  new String(chars);
    }
}
