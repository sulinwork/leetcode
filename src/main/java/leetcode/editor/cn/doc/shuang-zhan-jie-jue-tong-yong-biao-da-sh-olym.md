## 双栈解法

我们可以使用两个栈 `nums` 和 `ops` 。
* `nums` ： 存放所有的数字
* `ops` ：存放所有的数字以外的操作，+/-也看做是一种操作

然后从前往后做，对遍历到的字符做分情况讨论：
1. 如果是空格 : 跳过
2. 如果是 ( : 直接加入 ops 中，等待与之匹配的 )
3. 如果是 ) : 使用现有的 `nums` 和 `ops` 进行计算，直到遇到左边最近的一个左括号为止，计算结果放到 `nums`
4. 如果是 数字 : 从当前位置开始继续往后取，将整一个连续数字整体取出，加入 nums
5. 如果是 +/- : 需要将操作放入 `ops` 中。在**放入之前先把栈内可以算的都算掉**，使用现有的 `nums` 和 `ops` 进行计算，直到没有操作或者遇到左括号，计算结果放到 `nums`

一些细节：

* 由于第一个数可能是负数，为了减少边界判断。因此一个小技巧是先往 `nums` 添加一个 0

代码：
```java
class Solution {
    public int calculate(String s) {
        // 存放所有的数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        nums.addLast(0);
        // 存放所有的操作，包括 +/-
        Deque<Character> ops = new ArrayDeque<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == ' ') {
                continue;
            } else if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    char op = ops.peekLast();
                    if (op != '(') {
                        cal(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNum(c)) {
                    int u = 0;
                    int j = i;
                    // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                    while (j < n && isNum(cs[j])) u = u * 10 + (int)(cs[j++] - '0');
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    while (!ops.isEmpty() && ops.peekLast() != '(') cal(nums, ops);
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty()) cal(nums, ops);
        return nums.peekLast();
    }
    void cal(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        nums.addLast(op == '+' ? a + b : a - b);
    }
    boolean isNum(char c) {
        return Character.isDigit(c);
    }
}
```
* 时间复杂度：*O(n)*
* 空间复杂度：*O(n)*

***

## 进阶

1. 如果在此基础上，再考虑 `*` 和 `/`，需要增加什么考虑？如何维护运算符的优先级？
2. 在 1 的基础上，如果考虑支持自定义符号，例如 a / func(a, b) * (c + d)，需要做出什么调整？

*下午有时间就回来加上 ~*

***

## 最后

如果有帮助到你，请给个点赞关注，让更多的人看到 ~ ("▔□▔)/
