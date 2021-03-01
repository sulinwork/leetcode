package offer;

public class 正则表达式匹配 {
    public static void main(String[] args) {
        Solution solution = new 正则表达式匹配().new Solution();
        System.out.println(solution.isMatch("ab", ".*"));
    }

    class Solution {
        public boolean isMatch(String s, String p) {
            char[] sc = s.toCharArray();
            char[] pc = p.toCharArray();

            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            //对于p是"" 那么s是什么都是false
            //但是对于s 是"" 对于p  .* [a-z]* 都是成立的
            for (int i = 0; i < pc.length; i++) {
                if (pc[i] == '*') dp[0][i + 1] = dp[0][i - 1];
            }
            //状态转移方程
            for (int i = 0; i < sc.length; i++) {
                for (int j = 0; j < pc.length; j++) {
                    if (sc[i] == pc[j] || pc[j] == '.') dp[i + 1][j + 1] = dp[i][j];
                    else if (pc[j] == '*') {
                        //把.* 或者 [a-z]* 直接去掉看是否成立 成立就直接匹配  不成立考虑另一种条件
                        if (dp[i + 1][j - 1]) dp[i + 1][j + 1] = true;
                            // 去掉不匹配 那么考虑  *前面的是.或者是[a-z]匹配s当前字符
                        else if (pc[j-1] == '.' || pc[j - 1] == sc[i]) dp[i + 1][j + 1] = dp[i][j + 1];
                        //其他情况默认是false
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
