//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 347 👎 0

package leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：二叉树中所有距离为 K 的结点
public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
        // TO TEST
        TreeNode target = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                        new TreeNode(7),
                        new TreeNode(4)));
        TreeNode node = new TreeNode(3,
                target,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)));
        System.out.println(solution.distanceK(node, target, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            //遍历一遍
            Map<TreeNode, TreeNode> preMap = new HashMap<>();
            dfs(root, preMap);
            List<Integer> res = new ArrayList<>();
            searchK(target, k, target, preMap, res);
            return res;
        }

        public void dfs(TreeNode root, Map<TreeNode, TreeNode> preMap) {
            if (root == null) return;
            if (root.left != null) {
                preMap.put(root.left, root);
            }
            if (root.right != null) {
                preMap.put(root.right, root);
            }
            dfs(root.left, preMap);
            dfs(root.right, preMap);
        }

        public void searchK(TreeNode targetNode, int k, TreeNode fromNode, Map<TreeNode, TreeNode> preMap, List<Integer> res) {
            if (targetNode == null || k < 0) return;
            if (k == 0) {
                res.add(targetNode.val);
                return;
            }
            //左子树
            if (targetNode.left != null && targetNode.left != fromNode)
                searchK(targetNode.left, k - 1, targetNode, preMap, res);
            //右子树
            if (targetNode.right != null && targetNode.right != fromNode)
                searchK(targetNode.right, k - 1, targetNode, preMap, res);
            //父节点
            if (preMap.containsKey(targetNode) && preMap.get(targetNode) != fromNode)
                searchK(preMap.get(targetNode), k - 1, targetNode, preMap, res);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}