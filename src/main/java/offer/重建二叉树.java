package offer;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class 重建二叉树 {
    public static void main(String[] args) {
        Solution solution = new 重建二叉树().new Solution();
        System.out.println(solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> dict = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                dict.put(inorder[i], i);
            }
            return tree(preorder, dict, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode tree(int[] preorder, Map<Integer, Integer> dict, int left, int end, int inorderLeft, int inorderEnd) {
            if (left > end) return null;
            if (left == end) return new TreeNode(preorder[left]);
            TreeNode treeNode = new TreeNode(preorder[left]);
            int mid = dict.get(preorder[left]);
            treeNode.left = tree(preorder, dict, left + 1, left + mid - inorderLeft, inorderLeft, mid - 1);
            treeNode.right = tree(preorder, dict, left + mid - inorderLeft + 1, end, mid + 1, inorderEnd);
            return treeNode;
        }
    }
}

