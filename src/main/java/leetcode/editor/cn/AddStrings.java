//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 数学 字符串 模拟 
// 👍 408 👎 0

package leetcode.editor.cn;

//Java：字符串相加
public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        // TO TEST
        System.out.println(solution.addStrings("99", "9"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            if ("".equals(num1) && "".equals(num2)) return "";
            StringBuffer res = new StringBuffer();
            int len1 = num1.length();
            int len2 = num2.length();
            int maxLen = Math.max(len1, len2);
            int index = 0;
            int jin = 0;
            while (index < maxLen) {
                char a = index >= len1 ? '0' : num1.charAt(len1 - index - 1);
                char b = index >= len2 ? '0' : num2.charAt(len2 - index - 1);
                int sum = (a-'0') + (b-'0') + jin;
                res.append(sum % 10);
                jin = sum / 10;
                index++;
            }
            if (jin > 0) res.append(jin);
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}