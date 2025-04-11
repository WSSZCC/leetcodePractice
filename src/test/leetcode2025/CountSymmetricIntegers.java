package test.leetcode2025;

/**
 * 统计对称整数的数目
 */
public class CountSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if((i>10&&i<100)||(i>1000&&i<10000)){
                String s = String.valueOf(i);
                int v1 = 0;
                int v2=0;
                int length = s.length();
                for (int j = 0; j < length; j++) {
                    if(j<length/2){
                        v1+=s.charAt(i);
                    }else {
                        v2 += s.charAt(i);
                    }
                }
                if(v1==v2){
                    count++;
                }
            }
        }
        return count;
    }
}
