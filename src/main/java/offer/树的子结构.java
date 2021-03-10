package offer;

import java.sql.SQLOutput;

public class 树的子结构 {

    public static void main(String[] args) {
        Solution solution = new 树的子结构().new Solution();
        System.out.println(solution.isSubStructure(
                new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5)),
                new TreeNode(4, new TreeNode(1), null)));
    }

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A != null && B != null) {
                if (A.val == B.val) {
                    return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
                } else {
                    return isSubStructure(A.left, B) || isSubStructure(A.right, B);
                }
            }
            return false;
        }

        public boolean recur(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null || A.val != B.val) return false;
            return recur(A.left, B.left) && recur(A.right, B.right);
        }
    }
}
