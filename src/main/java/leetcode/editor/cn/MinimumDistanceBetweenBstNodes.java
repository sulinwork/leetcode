//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 100] 内 
// 0 <= Node.val <= 105 
// 
// 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 156 👎 0

package leetcode.editor.cn;

import offer.TreeNode;

//Java：二叉搜索树节点最小距离
public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int min = Integer.MAX_VALUE;

        //记录前一个节点的值
        public int pre = -1;

        public int minDiffInBST(TreeNode root) {
            dfs(root);
            return min;
        }

        public void dfs(TreeNode root) {
            //中序 左 中 右
            if (root == null) return;
            dfs(root.left);
            if (pre != -1) min = Math.min(min, root.val - pre);
            pre = root.val;
            dfs(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}