package test.leetcode2025;

import java.util.LinkedList;

/**
 * 设计一个文本编辑器
 */
public class TextEditor {
    LinkedList<Character> list;
    LinkedList<Character> list1;
    public TextEditor() {
        list = new LinkedList<>();
        list1 = new LinkedList<>();
    }

    public String addText(String text) {
        for (char c : text.toCharArray()) {
            list.addLast(c);
        }
        return null;
    }

    public int deleteText(int k) {
        int count = 0;
        while (!list.isEmpty()&&k>0){
            list.pollLast();
            k--;
            count++;
        }
        return count;
    }

    public String cursorLeft(int k) {
        int len = Math.min(10,k);
        while (!list.isEmpty()&&k>0){
            Character c = list.pollLast();
            list1.addFirst(c);
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()&&len>0){
            sb.append(list.pollLast());
            len--;
        }
        String s = sb.reverse().toString();
        for (char c : s.toCharArray()) {
            list.addLast(c);
        }
        return s;
    }

    public String cursorRight(int k) {
        int len = Math.min(10, k);
        while (!list1.isEmpty() && k > 0) {
            Character c = list1.pollFirst();
            list.addLast(c);
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty() && len > 0) {
            sb.append(list.pollLast());
            len--;
        }
        String s = sb.reverse().toString();
        for (char c : s.toCharArray()) {
            list.addLast(c);
        }
        return s;
    }
}
