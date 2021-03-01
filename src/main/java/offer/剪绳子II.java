package offer;


/**
 * 根据数据论证得出 当长度大于4的时候  每段长度切为3 乘积最大
 */
public class 剪绳子II {
    public static void main(String[] args) {
        System.out.println(new 剪绳子II().new Solution().cuttingRope(127));
    }

    class Solution {
        public int cuttingRope(int n) {
            if (n <= 3) return n - 1;
            if (n == 4) return 4;
            long res = 1;
            int mod = (int) (1e9 + 7);
            while (n > 4) {
                res *= 3;
                res %= mod;
                n -= 3;
            }
            return (int)(res * n % mod);
        }
    }
}
