package offer;

public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        Solution solution = new 二叉搜索树的后序遍历序列().new Solution();
        System.out.println(solution.verifyPostorder(new int[]{4, 6, 7, 5}));
    }

    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return dfs(postorder, 0, postorder.length - 1);
        }

        public boolean dfs(int[] p, int start, int end) {
            if (start >= end) return true;
            int head = p[end];
            //找到比这个小的位置
            int l = start;
            while (l < end && p[l] < head) l++;
            int r = end - 1;
            while (r >= start && p[r] > head) r--;
            return l == r + 1 && dfs(p, start, l - 1) && dfs(p, l, end - 1);
        }
    }
}
