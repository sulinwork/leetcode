//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1148 👎 0

package leetcode.editor.cn;

import javax.swing.*;

//Java：合并K个升序链表
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        // TO TEST
        ListNode listNode = solution.mergeKLists(new ListNode[]{});
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    //    // Definition for singly-linked list.
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

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            return divideAndConquer(lists, 0, lists.length - 1);
        }

        public ListNode divideAndConquer(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start];
            }
            if (end - start == 1) {
                return combine(lists[start], lists[end]);
            }
            int mid = (start + end) / 2;
            return combine(divideAndConquer(lists, start, mid), divideAndConquer(lists, mid + 1, end));
        }

        public ListNode combine(ListNode node1, ListNode node2) {
            ListNode root = new ListNode();
            ListNode temp = root;
            while (node1 != null || node2 != null) {
                if (node1 != null && node2 != null) {
                    ListNode node;
                    if (node1.val <= node2.val) {
                        node = node1;
                        node1 = node1.next;
                    } else {
                        node = node2;
                        node2 = node2.next;
                    }
                    temp.next = node;
                    temp = temp.next;
                    continue;
                }
                if (node1 == null) {
                    temp.next = node2;
                    node2 = node2.next;
                    temp = temp.next;
                    continue;
                }
                if (node2 == null) {
                    temp.next = node1;
                    node1 = node1.next;
                    temp = temp.next;
                    continue;
                }
            }
            return root.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}