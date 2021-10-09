//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 680 👎 0

package leetcode.editor.cn;

//Java：字符串相乘
public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        // TO TEST
        System.out.println(solution.multiply("9", "9"));
        System.out.println(solution.addStrings("9", "9"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) return "0";
            String res = "0";
            for (int i = num2.length() - 1; i >= 0; i--) {
                StringBuilder tempSum = new StringBuilder();
                for (int j = 0; j < num2.length() - 1 - i; j++) {
                    tempSum.append("0");
                }
                int jin = 0;
                for (int j = num1.length() - 1; j >= 0; j--) {
                    int n2 = num2.charAt(i) - '0';
                    int n1 = num1.charAt(j) - '0';
                    int result = n1 * n2;
                    tempSum.append((result + jin) % 10);
                    jin = (result + jin) / 10;
                }
                if (jin > 0) tempSum.append(jin);
                tempSum.reverse();
                String sum = addStrings(res, tempSum.toString());
                res = sum;
            }
            return res;
        }

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
                int sum = (a - '0') + (b - '0') + jin;
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