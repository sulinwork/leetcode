package offer;

public class 矩阵中的路径 {
    public static void main(String[] args) {
        Solution solution = new 矩阵中的路径().new Solution();
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        System.out.println(i + ":" + j);
                        boolean res = exist(board, word, 0, i, j, new boolean[board.length][board[i].length]);
                        if (res) return true;
                    }
                }
            }
            return false;
        }

        public boolean exist(char[][] board, String word, int index, int x, int y, boolean[][] cache) {
            if (index == word.length() - 1) return true;
            System.out.println("index:" + index);
            System.out.println("x:" + x + ",y:" + y);
            cache[x][y] = true;
            //左边
            boolean left = false;
            if (y > 0 && board[x][y - 1] == word.charAt(index + 1) && !cache[x][y - 1])
                left = exist(board, word, index + 1, x, y - 1, cache);
            //右边
            boolean right = false;
            if (y < board[0].length - 1 && board[x][y + 1] == word.charAt(index + 1) && !cache[x][y + 1])
                right = exist(board, word, index + 1, x, y + 1, cache);
            //上边
            boolean top = false;
            if (x > 0 && board[x - 1][y] == word.charAt(index + 1) && !cache[x - 1][y])
                top = exist(board, word, index + 1, x - 1, y, cache);
            //下边
            boolean below = false;
            if (x < board.length - 1 && board[x + 1][y] == word.charAt(index + 1) && !cache[x + 1][y])
                top = exist(board, word, index + 1, x + 1, y, cache);
            return left || right || top || below;
        }
    }
}
