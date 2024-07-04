package test.leetcode2024;

import java.util.*;

/**
 * 股票价格跨度
 */
public class StockSpanner {
    Deque<Integer> stack;
    List<Integer> prices;
    int index;

    public StockSpanner() {
        stack = new LinkedList<>();
        stack.push(-1);
        prices = new ArrayList<>();
        index = -1;
    }

    public int next(int price) {
        int curIndex = index;
        index++;
        prices.add(price);
        for (Integer next : stack) {
            curIndex = next;
            if (next > -1 && price < prices.get(next)) {
                break;
            }
        }
        if(curIndex==-1) {
            while(!stack.isEmpty()){
                stack.pop();
            }
            stack.push(-1);
        }
        stack.push(index);
        return index - curIndex;
    }
}
