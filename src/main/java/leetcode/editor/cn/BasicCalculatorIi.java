//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 288 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：基本计算器 II
public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        // TO TEST
        System.out.println(solution.calculate("3+5 / 2 "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private char[] array;

        private int index = 0;

        public int calculate(String s) {
            this.array = s.toCharArray();
            Stack<Integer> stack = new Stack<>();
            int sign = 1;
            while (index < array.length) {
                if (array[index] == ' ') {
                    index++;
                } else if (array[index] == '+') {
                    sign = 1;
                    index++;
                } else if (array[index] == '-') {
                    sign = -1;
                    index++;
                } else if (array[index] == '*') {
                    int pre = stack.pop();
                    index++;
                    int next = extract();
                    stack.push(pre * next);
                } else if (array[index] == '/') {
                    int pre = stack.pop();
                    index++;
                    int next = extract();
                    stack.push(pre / next);
                } else {
                    stack.push(sign * extract());
                }
            }
//            System.out.println(stack.toString());
            int ret = 0;
            for (Integer num : stack) {
                ret += num;
            }
            return ret;
        }

        private int extract() {
            int ret = 0;
            while (index < array.length) {
                if (array[index] == ' ') index++;
                else if (Character.isDigit(array[index])) {
                    ret = ret * 10 + (this.array[this.index] - '0');
                    this.index++;
                } else break;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}