//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1136 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：电话号码的字母组合
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if ("".equals(digits)) return res;
            String[] dist = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            combination(dist, digits, 0, new StringBuilder(), res);
            return res;
        }

        public void combination(String[] dist, String digits, int index, StringBuilder sb, List<String> res) {
            if (index == digits.length()) {
                res.add(sb.toString());
                return;
            }
            String letter = dist[digits.charAt(index) - '2'];
            for (char c : letter.toCharArray()) {
                sb.append(c);
                combination(dist, digits, index+1, sb, res);
                sb.deleteCharAt(index);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}