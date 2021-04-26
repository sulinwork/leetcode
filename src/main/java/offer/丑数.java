package offer;

import java.net.DatagramPacket;

public class 丑数 {
    public static void main(String[] args) {
        Solution solution = new 丑数().new Solution();
    }


    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            int a = 0, b = 0, c = 0;
            for (int i = 1; i < n; i++) {
                int n1 = dp[a] * 2, n2 = dp[b] * 3, n3 = dp[c] * 5;
                int min = Math.min(Math.min(n1, n2), n3);
                dp[i] = min;
                if (n1 == min) a++;
                if (n2 == min) b++;
                if (n3 == min) c++;
            }
            return dp[n - 1];
        }
    }
}

