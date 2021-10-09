//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 362 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：螺旋矩阵 II
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        // TO TEST
        int[][] matrix = solution.generateMatrix(3);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int lx = 0, ly = 0, rx = n - 1, ry = n - 1;
            int[][] res = new int[n][n];
            int index = 1;
            while (lx <= rx && ly <= ry) {
                index = padding(res, lx++, ly++, rx--, ry--, index);
            }
            return res;
        }

        public int padding(int[][] matrix, int lx, int ly, int rx, int ry, int index) {
            for (int i = ly; i <= ry; i++) {
                matrix[lx][i] = index++;
            }
            for (int i = lx + 1; i <= rx; i++) {
                matrix[i][ry] = index++;
            }
            for (int i = ry - 1; i >= ly && lx != rx; i--) {
                matrix[rx][i] = index++;
            }
            for (int i = rx - 1; i > lx && ly != ry; i--) {
                matrix[i][lx] = index++;
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}