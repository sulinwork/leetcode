package offer;

public class 把数字翻译成字符串2 {
    public static void main(String[] args) {
        Solution solution = new 把数字翻译成字符串2().new Solution();
        System.out.println(solution.translateNum(18822));
    }

    class Solution {
        private char[] array;

        public int translateNum(int num) {
            array = String.valueOf(num).toCharArray();
            int[] dp = new int[array.length];
            dp[0] = 1;
            for (int i = 1; i < array.length; i++) {
                //就一个
                dp[i] = dp[i - 1];
                //尝试两个
                if (array[i - 1] != '0' && extractTwo(i) <= 25) {
                    if (i - 2 > 0) dp[i] = dp[i] + dp[i - 2];
                    else dp[i] = dp[i] + 1;
                }
            }
            return dp[array.length - 1];
        }


        public int extractTwo(int start) {
            return (array[start - 1] - '0') * 10 + (array[start] - '0');
        }
    }
}
