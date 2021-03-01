package offer;

public class 矩阵中的路径 {
    public static void main(String[] args) {
        Solution solution = new 矩阵中的路径().new Solution();
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (dfs(board, chars, 0, i, j)) return true;
                }
            }
            return false;
        }

        public boolean dfs(char[][] board, char[] word, int index, int x, int y) {
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word[index])
                return false;
            if (index == word.length - 1) return true;
            board[x][y] = '\0';
            boolean res = dfs(board, word, index + 1, x + 1, y)
                    || dfs(board, word, index + 1, x - 1, y)
                    || dfs(board, word, index + 1, x, y + 1)
                    || dfs(board, word, index + 1, x, y - 1);
            board[x][y] = word[index];
            return res;
        }
    }
}
