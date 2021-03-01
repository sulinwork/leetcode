package offer;

import java.util.Arrays;

public class 剪绳子 {
    public static void main(String[] args) {
        Solution solution = new 剪绳子().new Solution();
        solution.cuttingRope(10);
    }

    class Solution {
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];
            // 初始状态
            dp[2] = 1;
            // 状态转移方程
            for (int i = 3; i < n + 1; i++) {
                System.out.println("i=" + i);
                for (int j = 1; j < i; j++) {
                    //表示第一段切为j 剩下的i-j 选择切则是j*dp[i-j]  或者不切j*(i-j)
                    dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
                }
            }
            // 返回值
            System.out.println(Arrays.toString(dp));
            return dp[n];
        }
    }
}
