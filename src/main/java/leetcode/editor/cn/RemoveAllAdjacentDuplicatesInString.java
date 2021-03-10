//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈 
// 👍 190 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：删除字符串中的所有相邻重复项
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        // TO TEST
        System.out.println(solution.removeDuplicates("abbaca"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /***
         * 栈解法
         * @param S
         * @return
         */
        public String removeDuplicates(String S) {
            StringBuilder sb = new StringBuilder();
            char[] chars = S.toCharArray();
            for (char aChar : chars) {
                if (sb.length() != 0 && sb.charAt(sb.length() - 1) == aChar) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(aChar);
                }
            }
            return sb.toString();
        }

        /**
         * 普通解法
         *
         * @param S
         * @return
         */
        public String removeDuplicates2(String S) {
            while (!"".equals(S)) {
                StringBuilder sb = new StringBuilder(S);
                boolean exit = true;
                for (int i = sb.length() - 1; i > 0; ) {
                    if (sb.charAt(i) == sb.charAt(i - 1)) {
                        exit = false;
                        sb.delete(i - 1, i + 1);
                        i--;
                    }
                    i--;
                }
                S = sb.toString();
                if (exit) break;
            }
            return S;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}