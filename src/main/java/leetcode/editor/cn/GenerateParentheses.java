//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1567 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // TO TEST
        System.out.println(solution.generateParenthesis(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n != 0) dfs(new StringBuilder(), n, n, res);
            return res;
        }

        public void dfs(StringBuilder curr, int left, int right, List<String> res) {
            if (left == 0 && right == 0) {
                res.add(curr.toString());
                return;
            }
            if (left > right) return;
            if (left > 0) {
                curr.append("(");
                dfs(curr, left - 1, right, res);
                //回溯  用string不需要回溯 string拼接本身返回一个新的对象
                curr.deleteCharAt(curr.length() - 1);
            }
            if (right > 0) {
                curr.append(")");
                dfs(curr, left, right - 1, res);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}