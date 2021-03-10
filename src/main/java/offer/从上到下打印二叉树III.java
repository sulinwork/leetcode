package offer;

import java.util.*;

public class 从上到下打印二叉树III {
    public static void main(String[] args) {
        Solution solution = new 从上到下打印二叉树III().new Solution();
        System.out.println(solution.levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
                add(root);
            }};
            while (!queue.isEmpty()) {
                LinkedList<Integer> line = new LinkedList<>();
                for (int i = queue.size()-1; i >=0 ; i--) {
                    TreeNode pop = queue.poll();
                    if ((res.size() & 1) == 0) line.addLast(pop.val);
                    else line.addFirst(pop.val);
                    if (pop.left != null) queue.add(pop.left);
                    if (pop.right != null) queue.add(pop.right);
                }
                res.add(line);
            }
            return res;
        }
    }
}
