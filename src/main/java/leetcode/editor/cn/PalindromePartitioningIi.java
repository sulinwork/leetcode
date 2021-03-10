//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 动态规划 
// 👍 331 👎 0

package leetcode.editor.cn;

//Java：分割回文串 II
public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
        // TO TEST
        System.out.println(solution.minCut("aabcvasfx"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            char[] array = s.toCharArray();
            int n = s.length();
            //求出不同位置上是否回文
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = i; j >= 0; j--) {
                    if (i == j) dp[i][j] = true;
                    else if (i - j == 1) dp[i][j] = array[i] == array[j];
                    else dp[i][j] = array[i] == array[j] && dp[i - 1][j + 1];
                }
            }
            //最小分割回文
            int[] f = new int[n];
            for (int i = 1; i < n; i++) {
                //如果和第一个构成回文 直接不用切分
                if (dp[i][0]) f[i] = 0;
                else {
                    //独立切割
                    f[i] = f[i - 1] + 1;
                    for (int j = 1; j < i; j++) {
                        //f[i] 上一次的最小切割数
                        //f[j-1] 当前for位置的切割数 + 当前位置到i形成回文 独立切割
                        if (dp[i][j]) f[i] = Math.min(f[i], f[j - 1] + 1);
                    }
                }
            }
            return f[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}