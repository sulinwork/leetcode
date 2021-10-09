//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 689 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：螺旋矩阵
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        // TO TEST
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(solution.spiralOrder(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int lx = 0, ly = 0, rx = matrix.length - 1, ry = matrix[0].length - 1;
            List<Integer> res = new ArrayList<>();
            while (lx <= rx && ly <= ry) {
                res.addAll(out(matrix, lx++, ly++, rx--, ry--));
            }
            return res;
        }

        public List<Integer> out(int[][] matrix, int lx, int ly, int rx, int ry) {
            List<Integer> res = new ArrayList<>();
            for (int i = ly; i <= ry; i++) {
                res.add(matrix[lx][i]);
            }
            for (int i = lx + 1; i <= rx; i++) {
                res.add(matrix[i][ry]);
            }
            for (int i = ry - 1; i >= ly && lx != rx; i--) {
                res.add(matrix[rx][i]);
            }
            for (int i = rx - 1; i > lx && ly != ry; i--) {
                res.add(matrix[i][lx]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}