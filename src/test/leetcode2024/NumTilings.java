package test.leetcode2024;

/**
 *  多米诺和托米诺平铺
 */
public class NumTilings {
    public static void main(String[] args) {
        numTilings(30);
    }

    public static int numTilings(int n) {
        if(n==1){return 1;}
        if(n==2){return 2;}
        if(n==3){return 5;}
        int a=1,b=2,c=5;
        for (int i = 4; i <=n; i++) {
            int temp = ((2*c)%1000000007+a)%1000000007;
            a=b;
            b=c;
            c=temp;
        }
        return c;
    }
}
