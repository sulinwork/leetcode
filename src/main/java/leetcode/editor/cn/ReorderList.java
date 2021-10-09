//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 栈 递归 链表 双指针 
// 👍 606 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：重排链表
public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        // TO TEST
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        solution.reorderList(node);
        System.out.println(node);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            ListNode temp = head;
            int len = 0;
            while (temp != null) {
                len++;
                temp = temp.next;
            }
            System.out.println("长度:" + len);
            int subLen = len - len / 2;
            System.out.println("第一个链表长度：" + subLen);
            Stack<ListNode> stack = new Stack<>();
            temp = head;
            for (int i = 0; i < subLen; i++) {
                stack.push(temp);
                temp = temp.next;
            }
            ListNode nextLinkHeadNode = stack.peek().next;
            stack.peek().next = null;
            while (!stack.isEmpty()) {
                ListNode pop = stack.pop();
                ListNode next = nextLinkHeadNode.next;
                nextLinkHeadNode.next = pop;
                stack.peek().next = nextLinkHeadNode;
                nextLinkHeadNode = next;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}