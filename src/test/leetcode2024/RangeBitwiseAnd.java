package test.leetcode2024;

/**
 * 数字范围按位与
 */
public class RangeBitwiseAnd {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd1(9,11));
    }

    public int rangeBitwiseAnd(int left, int right) {
        while(left<right){
            right=right&(right-1);
        }
        return right;
    }

    public static int rangeBitwiseAnd1(int left, int right) {
       if(left==0){
           return  0;
       }
       int temp = left;
       int len = 0;
       while (temp>0){
           temp>>=1;
           len++;
       }
       if(len<31&&right>=(1<<len)){
           return 0;
       }
       int target = 1;
       int value = right-left;
       len-=1;
       while (len>0){
           target<<=1;
           if(value<(1<<len)) {
               target++;
           }
           len--;
       }
       return left&Math.min(target,right);
    }
}
