package offer;

public class 把数字翻译成字符串 {
    public static void main(String[] args) {
        Solution solution = new 把数字翻译成字符串().new Solution();
        System.out.println(solution.translateNum(506));
    }

    class Solution {
        private char[] array;

        public int translateNum(int num) {
            array = String.valueOf(num).toCharArray();
            return dfs(0, "");
        }

        public int dfs(int index, String str) {
            if (index >= array.length) {
                System.out.println(str);
                return 1;
            }
            //取一个
            int one = extract(index, 1) <= 25 ? dfs(index + 1, str + " " + int2Char(extract(index, 1))) : 0;
            int two = extract(index, 2) <= 25 ? dfs(index + 2, str + " " + int2Char(extract(index, 2))) : 0;
            return one + two;
        }

        public int extract(int start, int num) {
            if (start + num > array.length) {
                return 26;
            }
            if (num > 1 && array[start] == '0') return 26;
            int ret = 0;
            while (num > 0 && start < array.length) {
                ret = ret * 10 + (array[start] - '0');
                start++;
                num--;
            }
            return ret;
        }

        public char int2Char(int a) {
            return (char) (a + 97);
        }
    }
}
