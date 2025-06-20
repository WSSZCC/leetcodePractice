package test.leetcode2025;

/**
 * K 次修改后的最大曼哈顿距离
 */
public class MaxDistance3443 {
    public int maxDistance(String s, int k) {
        int n = 0;
        int w = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'N':
                    n++;
                    break;
                case 'S':
                    n--;
                    break;
                case 'W':
                    w++;
                    break;
                default:
                    w--;
            }
            int value = Math.abs(n)+Math.abs(w)+2*k;
            int temp = Math.min(i+1,value);
            ans = Math.max(temp,ans);
        }
        return ans;
    }
}
