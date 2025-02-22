import java.util.*;

class Solution {
    private static class Node {
        public final int value;
        public final int x;
        public final int y;
        
        public Node left;
        public Node right;
        
        private Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
    
    private void insert(Node root, Node node) {
        if(node.x < root.x) {
            if(root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if(root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }
    
    private Node constructTree(Node[] nodes) {
        Node root = nodes[0];
        
        for(int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }
        return root;
    }
    
    private void pre(Node node, List<Integer> visits) {
        if(node == null) {
            return;
        }
        visits.add(node.value);
        pre(node.left, visits);
        pre(node.right, visits);
    }
    
    private void post(Node node, List<Integer> visits) {
        if(node == null) {
            return;
        }
        post(node.left, visits);
        post(node.right, visits);
        visits.add(node.value);
    }
    
    public int[][] solution(int[][] nodeInfo) {
        Node[] nodes = new Node[nodeInfo.length];
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1, nodeInfo[i][0], nodeInfo[i][1]);
        }
        Arrays.sort(nodes, (a, b) -> b.y - a.y);
        
        Node root = constructTree(nodes);
        
        List<Integer> preOrder = new ArrayList<>();
        pre(root, preOrder);
        
        List<Integer> postOrder = new ArrayList<>();
        post(root, postOrder);
        
        return new int[][] {
            preOrder.stream().mapToInt(Integer::intValue).toArray(), 
            postOrder.stream().mapToInt(Integer::intValue).toArray()
        };
    }
}