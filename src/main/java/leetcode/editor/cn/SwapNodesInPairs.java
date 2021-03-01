//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 827 👎 0

package leetcode.editor.cn;

//Java：两两交换链表中的节点
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        // TO TEST
        ListNode listNode = solution.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }

    public static class ListNode {
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
        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;
            ListNode root = new ListNode(-1, head);
            ListNode pre = root;
            ListNode l1 = head;
            ListNode l2 = head.next;
            while (l2 != null) {
                pre.next = l2;
                l1.next = l2.next;
                l2.next = l1;

                pre = l1;
                for (int i = 0; i < 3; i++) {
                    if (l2 != null) l2 = l2.next;
                }
                if (l1 != null) l1 = l1.next;
            }
            return root.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;
        }
    }
}