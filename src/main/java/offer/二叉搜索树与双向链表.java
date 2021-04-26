package offer;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        Solution solution = new 二叉搜索树与双向链表().new Solution();
        Node node = solution.treeToDoublyList(new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5)));
        System.out.println();

    }

    class Solution {
        private Node head;
        private Node pre;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        public void dfs(Node node) {
            if (node == null) return;
            dfs(node.left);
            //第一个到这里的肯定是中序遍历的第一个
            if (pre == null) head = node;
            else pre.right = node;
            node.left = pre;
            pre = node;
            dfs(node.right);
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}