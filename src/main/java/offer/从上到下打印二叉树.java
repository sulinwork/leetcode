package offer;

import java.util.*;

public class 从上到下打印二叉树 {
    public static void main(String[] args) {
        Solution solution = new 从上到下打印二叉树().new Solution();
        System.out.println(Arrays.toString(solution.levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))))));
    }

    class Solution {
        public int[] levelOrder(TreeNode root) {
            if(root==null) return new int[]{};
            List<Integer> list = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
                add(root);
            }};
            while (!queue.isEmpty()) {
                TreeNode pop = queue.poll();
                list.add(pop.val);
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;

        }
    }
}
