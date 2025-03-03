package test.leetcode2025;

import test.entry.Node;

import java.util.LinkedList;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class Connect {
    public Node connect(Node root) {
        if(root!=null) {
            LinkedList<Node> list = new LinkedList<>();
            list.addFirst(root);
            while (!list.isEmpty()) {
                int n = list.size();
                for (int i = 0; i < n; i++) {
                    Node node = list.pollLast();
                    if (i < n - 1) {
                        node.next = list.peekLast();
                    }
                    if (node.left!=null){
                        list.addFirst(node.left);
                    }
                    if(node.right!=null){
                        list.addFirst(node.right);
                    }
                }
            }
        }
        return root;
    }
}
