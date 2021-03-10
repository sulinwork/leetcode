//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
//
// 
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 
//
// 
//
// 示例： 
//
// 
//给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设矩阵不可变。 
// 会多次调用 sumRegion 方法。 
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。 
// 
// Related Topics 动态规划 
// 👍 172 👎 0

package leetcode.editor.cn;

//Java：二维区域和检索 - 矩阵不可变
public class RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        NumMatrix num = new RangeSumQuery2dImmutable().new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        System.out.println(num.sumRegion(2, 1, 4, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        private int[][] sumMatrix;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) return;
            if (sumMatrix == null) sumMatrix = new int[matrix.length][matrix[0].length];
            sumMatrix[0][0] = matrix[0][0];
            for (int i = 1; i < sumMatrix.length; i++) {
                sumMatrix[i][0] = sumMatrix[i - 1][0] + matrix[i][0];
            }
            for (int i = 1; i < sumMatrix[0].length; i++) {
                sumMatrix[0][i] = sumMatrix[0][i - 1] + matrix[0][i];
            }
            for (int i = 1; i < sumMatrix.length; i++) {
                for (int j = 1; j < sumMatrix[i].length; j++) {
                    sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int cover = 0;
            if (row1 - 1 >= 0 && col1 - 1 >= 0) cover = sumMatrix[row1 - 1][col1 - 1];
            return sumMatrix[row2][col2] -
                    ((col1 - 1) >= 0 ? sumMatrix[row2][col1 - 1] : 0) -
                    ((row1 - 1) >= 0 ? sumMatrix[row1 - 1][col2] : 0) +
                    cover;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}