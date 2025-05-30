package test.leetcode2025;

import java.util.Arrays;

/**
 * 找到离给定两个节点最近的节点
 */
public class ClosestMeetingNode {
    public static void main(String[] args) {
        System.out.println(closestMeetingNode(new int[]{5,4,5,4,3,6,-1},0,1));
    }
    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        boolean[] booleans1 = new boolean[n];
        boolean[] booleans2 = new boolean[n];
        Arrays.fill(booleans1,false);
        Arrays.fill(booleans1,false);
        while (!booleans1[node1]||!booleans2[node2]){
            booleans1[node1]=true;
            booleans2[node2] = true;
            if(booleans2[node1]){
                n = node1;
            }
            if(booleans1[node2]){
                n = Math.min(node2,n);
            }
            if(n<edges.length){
                return n;
            }
            if(edges[node1]>=0){
                node1 = edges[node1];
            }
            if(edges[node2]>=0){
                node2 = edges[node2];
            }
        }
        return -1;

    }
    public static int closestMeetingNode1(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] booleans = new int[n];
        Arrays.fill(booleans,0);
        booleans[node1] = 1;
        while (edges[node1]!=-1&&booleans[edges[node1]]==0){
            booleans[edges[node1]] = 1;
            node1 = edges[node1];
            if(node1 ==node2){
                return node1;
            }
        }
        booleans[node2] = 2;
       while (edges[node2]!=-1&&booleans[edges[node2]]!=2){
           if(booleans[edges[node2]]==1){
               return edges[node2];
           }else {
               booleans[edges[node2]] = 2;
               node2 = edges[node2];
           }
       }
        return -1;
    }
}
