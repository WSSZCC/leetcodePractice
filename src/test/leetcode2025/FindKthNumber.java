package test.leetcode2025;

public class FindKthNumber {
    int value ;
    int times;
    public int findKthNumber(int n, int k) {
        value = 0;
        times = k;
        for (int i = 1; i <= 9; i++) {
            dfs(i,n);
        }
        return value;
    }

    private void dfs(int i, int n) {
        for (int j = 0; j <= 9; j++) {
            if(i>n){
                return;
            }
            if(times==1){
                value = i;
            }
            times--;
            if(times<0){
                return;
            }
            dfs(i*10+j,n);
        }
    }
}
