package test.leetcode2025;

/**
 * 找出第 K 个字符 I
 */
public class KthCharacter {
    char[] chars;
    int max = 500;
    boolean isTrue = false;

    public void build(){
        if(isTrue){
            return;
        }
        chars = new char[max];
        chars[0] = 'a';
        int index = 1;
        while (true){
            int flag = index;
            for (int i = 0; i < flag; i++) {
                if(index>=500){
                    break;
                }
                int i1 = (chars[i] - 'a') + 1;
                chars[index] = (char) ('a'+(i1%26));
                index++;
            }
            if(index>=500){
                break;
            }
        }
    }
    public char kthCharacter(int k) {
        build();
        isTrue = true;
        return chars[k-1];
    }
}
