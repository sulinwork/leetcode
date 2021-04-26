package offer;

public class 二维数组中查找 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 5));
        System.out.println(solution.findNumberIn2DArray(new int[][]{}, 0));

    }
}

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int x = 0, y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] < target) x++;
            else y--;
        }
        return false;
    }
}