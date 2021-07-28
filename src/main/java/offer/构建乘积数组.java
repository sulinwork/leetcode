package offer;

import java.util.Arrays;

public class 构建乘积数组 {
    public static void main(String[] args) {
        Solution solution = new 构建乘积数组().new Solution();
        solution.constructArr(new int[]{1, 2, 3, 4, 5});
    }

    class Solution {
        public int[] constructArr(int[] a) {
            if (a == null) return null;
            if (a.length == 0) return new int[]{0};
            int[] b = new int[a.length];
            b[0] = 1;
            //第一次计算左边的
            for (int i = 1; i < a.length; i++) {
                b[i] = b[i - 1] * a[i - 1];
            }
            //System.out.println(Arrays.toString(b));
            int temp = a[a.length - 1];
            for (int i = a.length - 2; i >= 0; i--) {
                b[i] = b[i] * temp;
                temp = temp * a[i];
            }
            //System.out.println(Arrays.toString(b));
            return b;
        }
    }
}
