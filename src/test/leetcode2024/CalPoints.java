package test.leetcode2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 棒球比赛
 */
public class CalPoints {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (String operation : operations) {
            getOperation(list,operation);
        }
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private void getOperation(List<Integer> list, String operation) {
        int size = list.size();
        if(operation.equals("+")){
            list.add(list.get(size-2)+list.get(size-1));
            return;
        }
        if(operation.equals("D")){
            list.add(list.get(size-1)*2);
            return;
        }
        if(operation.equals("C")){
            list.remove(size-1);
        }else {
            int i = Integer.parseInt(operation);
            list.add(i);
        }
    }
}
