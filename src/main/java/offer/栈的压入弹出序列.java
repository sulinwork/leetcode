package offer;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public static void main(String[] args) {
        Solution solution = new 栈的压入弹出序列().new Solution();
        System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int popIndex = 0;
            for (int i = 0; i < pushed.length || !stack.isEmpty(); ) {
                if (i < pushed.length && (stack.isEmpty() || stack.peek() != popped[popIndex])) {
                    stack.push(pushed[i]);
                    i++;
                } else if (stack.peek() == popped[popIndex]) {
                    stack.pop();
                    popIndex++;
                } else return false;
            }
            return stack.isEmpty();
        }
    }
}
