package test.leetcode2024;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 简化路径
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String s = "/...";
        String substring = s.substring(0,4);
        System.out.println("/.../a/../b/c/../d/./");
        simplifyPath("/a/./b/../../c/");
    }

    public static String simplifyPath(String path) {
        int n = path.length();
        Deque<Character> queue = new LinkedList<>();
        queue.add(path.charAt(0));
        int index = 1;
        while (index<n) {
            char c = path.charAt(index);
            if(!queue.isEmpty()&&queue.peekLast()=='/'){
                int value = getNeedOffSetValue(c, n, index, path);
                if(value>0){
                    if(value==3&&queue.size()>1){
                        queue.pollLast();
                        while (!queue.isEmpty()&&queue.peekLast()!='/'){
                            queue.pollLast();
                        }
                    }
                    index+=value;
                    continue;
                }
            }
            queue.add(c);
            index++;
        }
        StringBuffer buffer = new StringBuffer();
        if (queue.size() > 1 && queue.peekLast() == '/') {
            queue.pollLast();
        }
        while (!queue.isEmpty()) {
            buffer.append(queue.pollFirst());
        }
        return buffer.toString();
    }
    private static int getNeedOffSetValue(char c, int n, int i, String path){
        if(c=='/'){
            return 1;
        }
        if(i<n-1&& path.startsWith("./", i)||(i==n-1&&c=='.')){
            return 2;
        }
        if(i<n-2&& path.startsWith("../", i)||(i==n-2&&path.startsWith("..",i))){
            return 3;
        }
        return 0;
    }

}
