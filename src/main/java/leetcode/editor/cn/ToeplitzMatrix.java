//给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。 
//
// 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
//输出：true
//解释：
//在上述矩阵中, 其对角线为: 
//"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。 
//各条对角线上的所有元素均相同, 因此答案是 True 。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2],[2,2]]
//输出：false
//解释：
//对角线 "[1, 2]" 上的元素不同。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 20 
// 0 <= matrix[i][j] <= 99 
// 
//
// 
//
// 进阶： 
//
// 
// 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？ 
// 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？ 
// 
// Related Topics 数组 
// 👍 199 👎 0

package leetcode.editor.cn;

//Java：托普利茨矩阵
public class ToeplitzMatrix {
    public static void main(String[] args) {
        Solution solution = new ToeplitzMatrix().new Solution();
        // TO TEST
        System.out.println(solution.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 2, 1, 3}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            //3,0 2,0 1,0 0,0 0,1 0,2
            int m = matrix.length;
            int n = matrix[0].length;
            //左上角老师
            int x = matrix.length - 1;
            int y = 0;
            boolean res = true;
            while (x >= 0 && y < n) {
                if ((x == m - 1 && y == 0) || (x == 0 && y == n - 1)) {
                    if (x == m - 1 && y == 0) x--;
                    else y++;
                } else {
                    int tempX = x;
                    int tempY = y;
                    while (tempX < m && tempY < n) {
                        if (tempX > x && tempY > y)
                            res = matrix[tempX][tempY] == matrix[tempX - 1][tempY - 1];
                        if (!res) {
                            return false;
                        }
                        tempX++;
                        tempY++;
                    }

                    if (x == 0) {
                        y++;
                    } else {
                        x--;
                    }
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}