package offer;

/**
 * 不能使用条件if 循环for while 等
 * 不能使用乘法和除法
 */
public class 求1到n的和 {
    public static void main(String[] args) {
        Solution solution = new 求1到n的和().new Solution();

        System.out.println(solution.sumNums(9));
    }

    class Solution {
        public int sumNums(int n) {
            boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
            return n;
        }
    }
}
