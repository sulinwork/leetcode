package 面试题;

import common.Node;

/**
 * 单链表 区间反转
 */
public class LinkRangeReverse {

    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        root = new LinkRangeReverse().reverse(root);
        System.out.println(root);
    }

    public Node reverse(Node root) {
        //root = new Node(99, null);
        Node head = root;
        while (head.next != null) {
            Node current = head.next;
            head.next = head.next.next;
            current.next = root;
            root = current;
        }
        return root;
    }

    public void reverse(Node root, int start, int end) {
        if (start >= end) return;
        Node newTempRoot = new Node(-1, root);
        Node reverseHead = null;
        int len = 0;
        while (newTempRoot != null) {
            if (len == start - 1) {
                reverseHead = newTempRoot;
                break;
            }
            newTempRoot = newTempRoot.next;
            len++;
        }
        Node needReverseNode = reverseHead.next;
        for (int i = start; i < end; i++) {
            Node currentNode = needReverseNode.next;
            Node nextHolderNode = currentNode.next;
            needReverseNode.next = nextHolderNode;
            currentNode.next = reverseHead.next;
            reverseHead.next = currentNode;
        }
    }
}
