package offer;

import java.util.Arrays;

/**
 * 双指针 或者 动态规划
 *
 *
 */
public class 股票的最大利润 {
    public static void main(String[] args) {
        Solution solution = new 股票的最大利润().new Solution();
        System.out.println(solution.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }

    class Solution {
        //双指针  最小指针只想前面的最低点（假设总是在前面的最低点买入）,每次出现比最低点高就假设卖出
        //关键在于找访问过元素的最小值  所以还可以借助单调栈  栈顶一直保持访问过元素的最小值即可
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int min = prices[0];
            int maxProfit = 0;
            for (int j = 1; j < prices.length; j++) {
                if (prices[j] < min) min = prices[j];
                else maxProfit = Math.max(maxProfit, prices[j] - min);
            }
            return maxProfit;
        }

        //动态规划  很明显dp[i] 只会关乎dp[i-1]  可以使用两个变量来代替dp表  节省空间复杂度
        public int maxProfit2(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;//第一天不持有
            dp[0][1] = -prices[0];//第一天持有
            for (int i = 1; i < prices.length; i++) {
                //今天不持有= Max(昨天不持有 or 昨天持有今天卖出)
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                //今天持有= Max(昨天持有 or 昨天不持有并今天买入)
                //dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);//不能这么写
                dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]); //题目要求只能买卖一次
            }
            return dp[prices.length - 1][0];
        }
    }
}
