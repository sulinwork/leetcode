package offer;

import java.util.Arrays;

public class 把数组排成最小的数 {
    public static void main(String[] args) {
        Solution solution = new 把数组排成最小的数().new Solution();
        System.out.println(solution.minNumber(new int[]{3, 30, 34, 5, 9}));
    }


    class Solution {
        public String minNumber(int[] nums) {
            String[] strNums = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strNums[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strNums, (x, y) -> (x + y).compareTo(y + x));
            StringBuilder res = new StringBuilder();
            for (String s : strNums)
                res.append(s);
            return res.toString();
        }
    }
}
