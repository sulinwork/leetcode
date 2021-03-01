package offer;

public class 表示数值的字符串 {
    public static void main(String[] args) {
        Solution solution = new 表示数值的字符串().new Solution();
        String[] array = "+100、5e2、-123、3.1416、-1E-16、0123".split("、");
        for (String s : array) {
            System.out.println(solution.isNumber(s));
        }

    }

    class Solution {
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) return false;
            boolean num = false;
            boolean dot = false;
            boolean e = false;
            char[] chars = s.trim().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') num = true;
                else if (chars[i] == '.') {
                    //. 的前面不能出现.和e
                    if (dot || e) {
                        return false;
                    }
                    dot = true;
                } else if (chars[i] == 'e' || chars[i] == 'E') {
                    //e的前面不能有e 前面必须出现数
                    if (e || !num) {
                        return false;
                    }
                    e = true;
                    //重置num 因为e后面必须出现数字才合法
                    num = false;
                } else if (chars[i] == '-' || chars[i] == '+') {
                    //+-出现在首位  或者e的后面第一个位置
                    if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') return false;
                } else return false;
            }
            return num;
        }
    }
}
