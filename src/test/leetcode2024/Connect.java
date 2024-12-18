package test.leetcode2024;

import test.entry.ListNode;
import test.entry.Node;

import java.util.LinkedList;

/**
 * 填充每个节点的下一个右侧节点指针
 */
public class Connect {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node node = root;
        Node node1 = new Node();
        Node node2 = node1;
        int flag = 1;
        int count = 1;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            Node poll = list.poll();
            node2.next = poll;
            node2 = node2.next;

            if(poll.left!=null){
                list.add(poll.left);
            }
            if(poll.right!=null){
                list.add(poll.right);
            }
            count--;
            if(count==0){
                flag*=2;
                count= flag;
                node.right = node1.next.left;
                node = node.right;
                node1 = new Node();
                node2 = node1;
            }
        }
        return root.right;
    }
}
