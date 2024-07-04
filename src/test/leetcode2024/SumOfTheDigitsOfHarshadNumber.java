package test.leetcode2024;

/**
 * 哈沙德数
 */
public class SumOfTheDigitsOfHarshadNumber {
    public static void main(String[] args) {

    }
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum=0;
        int temp = x;
        while (temp/10>0){
            sum+=temp%10;
            temp = temp/10;
        }
        if(x%(sum+temp)!=0){
            return -1;
        }
        return sum+temp;
    }
}
