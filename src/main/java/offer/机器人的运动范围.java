package offer;

public class 机器人的运动范围 {
    public static void main(String[] args) {
        Solution solution = new 机器人的运动范围().new Solution();
        System.out.println(solution.movingCount(3,1, 4));
    }

    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] cache = new boolean[m][n];
            return dfs(0, 0, m, n, k, cache);
        }

        public int dfs(int x, int y, int m, int n, int k, boolean[][] cache) {
            if (x < 0 || y < 0 || x >= m || y >= n || cache[x][y]) return 0;
            if (sum(x, y) > k) return 0;
            cache[x][y] = true;
            //从官方题解中得知：其实只需要向下和右就行了  不需要四个方向
            return 1 + dfs(x + 1, y, m, n, k, cache) + dfs(x - 1, y, m, n, k, cache) + dfs(x, y + 1, m, n, k, cache) + dfs(x, y - 1, m, n, k, cache);
        }

        public int sum(int i, int j) {
            int res = 0;
            while (i > 0) {
                res += i % 10;
                i = i / 10;
            }
            i = j;
            while (i > 0) {
                res += i % 10;
                i = i / 10;
            }
            return res;
        }
    }
}
