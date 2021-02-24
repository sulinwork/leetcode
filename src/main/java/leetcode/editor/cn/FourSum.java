//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 750 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：四数之和

/**
 * 官方推荐：思路还是和三数之和一样
 * 大佬推荐：回溯（会超时） 需要剪枝(优化)
 */
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        // TO TEST
        System.out.println(solution.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (j - i > 1 && nums[j] == nums[j - 1]) continue;
                    //枚举前两个数字
                    //双指针后两个

                    int start = j + 1;
                    int end = nums.length - 1;
                    while (start < end) {
                        if (start > j + 1 && nums[start] == nums[start - 1]) {
                            start++;
                            continue;
                        }
                        if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                            end--;
                            continue;
                        }
                        int sum = nums[i] + nums[j] + nums[start] + nums[end];
                        if (sum == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[start]);
                            temp.add(nums[end]);
                            res.add(temp);
                            start++;
                            end--;
                            continue;
                        }
                        if (sum < target) {
                            start++;
                            continue;
                        }
                        if (sum > target) {
                            end--;
                            continue;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}