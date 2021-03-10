//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 404 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Stack;

//Java：基本计算器

/**
 * 只要用栈记录 每个括号前面的符号即可
 */
public class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
        // TO TEST

        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            char[] array = s.toCharArray();
            Stack<Integer> opera = new Stack<>();
            opera.add(1);
            int i = 0;
            int n = array.length;
            int ret = 0;
            int sign = 1;
            while (i < n) {
                if (array[i] == ' ') {
                    i++;
                } else if (array[i] == '+') {
                    //当前是加号 那么和括号外面的一直
                    sign = opera.peek();
                    i++;
                } else if (array[i] == '-') {
                    sign = -opera.peek();
                    i++;
                } else if (array[i] == '(') {
                    opera.push(sign);
                    i++;
                } else if (array[i] == ')') {
                    opera.pop();
                    i++;
                } else {
                    int num = 0;
                    //数字
                    while (i < n && Character.isDigit(array[i])) {
                        num = num * 10 + (array[i] - '0');
                        i++;
                    }
                    ret += sign * num;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}