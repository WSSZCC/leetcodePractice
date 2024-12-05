package test.leetcode2024;

/**
 * 捕获黑皇后需要的最少移动次数
 */
public class MinMovesToCaptureTheQueen {
    public static void main(String[] args) {
        System.out.println(minMovesToCaptureTheQueen(1,1,1,4,1,8));
    }
    public static int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if((a==e&&a!=c)||(b==f&&b!=d)||(a==e&&a==c&&!((b<f&&d<f&&d>b)||(b>f&&d>f&&d<b)))||(b==f&&d==f&&!((a<e&&c<e&&c>a)||(a>e&&c>e&&c<a)))){
            return 1;
        }
        int x = e-c;
        int y = f-d;
        int x1 = e-a;
        int y1 = f-b;
        if(Math.abs(x)==Math.abs(y)&&((Math.abs(x1)!=Math.abs(y1))||(Math.signum(x)!=Math.signum(x1))||(Math.signum(y)!=Math.signum(y1))||(Math.abs(x)<Math.abs(x1)))){
            return 1;
        }
        return 2;
    }
}
