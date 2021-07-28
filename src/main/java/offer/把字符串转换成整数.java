package offer;

public class 把字符串转换成整数 {
    public static void main(String[] args) {
        Solution solution = new 把字符串转换成整数().new Solution();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(solution.strToInt("-   234"));
    }

    class Solution {
        int symbol = 1;
        boolean isSymbol = false;
        boolean isTrim = true;

        public int strToInt(String str) {
            char[] array = str.toCharArray();

            int index = 0;
            while (index < array.length) {
                if (isTrim && array[index] == ' ') {
                    index++;
                    continue;
                }
                if (!isSymbol && array[index] == '+') {
                    isSymbol = true;
                    symbol = 1;
                    index++;
                    isTrim = false;
                    continue;
                }
                if (!isSymbol && array[index] == '-') {
                    isSymbol = true;
                    symbol = -1;
                    index++;
                    isTrim = false;
                    continue;
                }
                if (isNumber(array[index])) {
                    isTrim = false;
                    int end = index + 1;
                    while (end < array.length && isNumber(array[end])) end++;
                    return str2Int(array, index, end - 1);
                }
                return 0;
            }

            return 0;
        }

        public boolean isNumber(char c) {
            return c >= '0' && c <= '9';
        }

        public int str2Int(char[] array, int start, int end) {
            long res = 0;
            while (start <= end) {
                if (symbol == 1) {
                    if ((res * 10 > Integer.MAX_VALUE) || (res == Integer.MAX_VALUE / 10 && (array[start] - '0') > Integer.MAX_VALUE % 10)) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if ((res * 10 * symbol < Integer.MIN_VALUE) || (res * symbol == Integer.MIN_VALUE / 10 && (array[start] - '0') * symbol < Integer.MIN_VALUE % 10)) {
                        return Integer.MIN_VALUE;
                    }
                }
                res = res * 10 + (array[start] - '0');
                start++;
            }
            return (int) (res * symbol);
        }
    }
}
