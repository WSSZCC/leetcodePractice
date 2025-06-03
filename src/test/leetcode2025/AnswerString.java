package test.leetcode2025;

/**
 * 从盒子中找出字典序最大的字符串 I
 */
public class AnswerString {
    public static void main(String[] args) {
        System.out.println(answerString("aann",2));
    }
    public static String answerString(String word, int numFriends) {
        if(numFriends==1){
            return word;
        }
        int n = word.length();
        int flag = n - numFriends + 1;
        String s = "";
        int index = 0;
        while (index<n){
            String substring = word.substring(index, Math.min(n,flag+index));
            if(substring.compareTo(s)>0){
                s=substring;
            }
            index++;
        }
        return s;
    }
}
