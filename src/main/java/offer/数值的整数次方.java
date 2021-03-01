package offer;

/**
 * 快速幂
 */
public class 数值的整数次方 {
    public static void main(String[] args) {
        Solution solution = new 数值的整数次方().new Solution();
        System.out.println(solution.myPow(2.00000,-2));
    }

    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            //因为int类型范围：[−2147483648,2147483647] 故当n为Integer.MIN_VALUE时 他的相反数超出Integer.MAX_VALUE的值 溢出了
            //所以 我们对n进行-1
//            if (x < 0) return myPow(1 / x, -n);
            if (n < 0) return (1 / x) * myPow(1 / x, -(n + 1));
            //n 是奇数 比如：n^3 = n * n^2
            //n>>1 等价于 n/2
            if ((n & 1) == 1) return x * myPow(x * x, n >> 1);
                //偶数
            else return myPow(x * x, n >> 1);
        }
    }
}
