//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1226 👎 0

package leetcode.editor.cn;

//Java：删除链表的倒数第 N 个结点
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
        System.out.println(solution.removeNthFromEnd(new ListNode(1), 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    //Definition for singly-linked list.
    //提交的时候删除本类
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode root = new ListNode(0,head);
            ListNode one = root;
            ListNode two = root;
            for (int i = 0; i < n; i++) {
                two = two.next;
            }
            while (two.next != null) {
                one = one.next;
                two = two.next;
            }
            //one的下一个节点就是需要删除的
            one.next = one.next.next;
            return root.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}