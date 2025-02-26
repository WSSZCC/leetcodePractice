package test.leetcode2025;

import java.util.LinkedList;

/**
 * 1472. 设计浏览器历史记录
 */
public class BrowserHistory {
    LinkedList<String> list1;
    LinkedList<String> list2;
    String curUrl = "";
    public BrowserHistory(String homepage) {
        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
        curUrl = homepage;

    }

    public void visit(String url) {
        list1.addLast(curUrl);
        curUrl = url;
    }

    public String back(int steps) {
        while (!list1.isEmpty()&&steps>0){
            String s = list1.pollLast();
            list2.addFirst(curUrl);
            curUrl = s;
            steps--;
        }
        return curUrl;
    }

    public String forward(int steps) {
        while (!list2.isEmpty()&&steps>0){
            String s = list2.pollFirst();
            list1.addLast(curUrl);
            curUrl = s;
            steps--;
        }
        return curUrl;
    }
}
