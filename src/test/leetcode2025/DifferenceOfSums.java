package test.leetcode2025;

/**
 * 分类求和并作差
 */
public class DifferenceOfSums {
    public int differenceOfSums(int n, int m) {
        int sum = n*(n+1)/2;
        int flag=1;
        while (flag*m<=n){
            sum-=(2*flag*m);
            flag++;
        }
        return sum;
    }
}
