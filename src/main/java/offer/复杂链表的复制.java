package offer;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {
    public static void main(String[] args) {
        Solution solution = new 复杂链表的复制().new Solution();
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Node root = solution.copyRandomList(n1);
        while (root != null) {
            System.out.println(root.val + "," + (root.random != null ? root.random.val : "null"));
            root = root.next;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node cur = head;
            while (cur != null) {
                Node newNode = new Node(cur.val);
                newNode.next = cur.next;
                cur.next = newNode;
                cur = newNode.next;
            }
            cur = head;
            while (cur != null) {
                if (cur.random != null)
                    cur.next.random = cur.random.next;
                cur = cur.next.next;
            }
            cur = head.next;
            Node pre = head;
            Node res = head.next;
            while (cur.next != null) {
                pre.next = pre.next.next;
                cur.next = cur.next.next;
                pre = pre.next;
                cur = cur.next;
            }
            pre.next=null;
            return res;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
            this.random = null;
        }
    }
}
