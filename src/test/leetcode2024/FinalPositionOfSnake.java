package test.leetcode2024;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 矩阵中的蛇
 */
public class FinalPositionOfSnake {
    public int finalPositionOfSnake(int n, List<String> commands) {
        Map<String, Integer> map = new HashMap<>();
        map.put("RIGHT", 1);
        map.put("LEFT", -1);
        map.put("DOWN", n);
        map.put("UP", -n);
        int ans = 0;
        for (String command : commands) {
            ans+=map.get(command);
        }
        return ans;
    }
}
