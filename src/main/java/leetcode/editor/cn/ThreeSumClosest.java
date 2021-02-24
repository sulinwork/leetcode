//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 695 👎 0

package leetcode.editor.cn;

import java.time.chrono.MinguoDate;
import java.util.Arrays;

//Java：最接近的三数之和
public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        // TO TEST
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int minDiff = 0;
            for (int i = 0; i < nums.length; i++) {
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int tempSum = nums[i] + nums[start] + nums[end];
                    if (tempSum == target) return target;
                    if (minDiff == 0) {
                        minDiff = tempSum - target;
                    } else {
                        if (Math.abs(tempSum - target) < Math.abs(minDiff)) minDiff = tempSum - target;
                    }
                    if (tempSum > target) end--;
                    else start++;
                }
            }
            return minDiff + target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}