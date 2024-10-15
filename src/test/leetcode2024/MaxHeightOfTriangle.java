package test.leetcode2024;

/**
 * 三角形的最大高度
 */
public class MaxHeightOfTriangle {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(cal(red,blue),cal(blue,red));
    }

    private int cal(int v1, int v2) {
        boolean isFirst = true;
        int i = 0;
        int pre = 1;
        while (true){
            if(isFirst){
                v1-=pre;
                if(v1<0){
                    break;
                }
            }else {
                v2-=pre;
                if(v2<0){
                    break;
                }
            }
            pre++;
            i++;
            isFirst = !isFirst;
        }
        return i;
    }
}
