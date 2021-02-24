//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2974 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：三数之和
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // TO TEST
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int twoSumTarget = -nums[i];
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (start > i + 1 && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }
                    if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                        end--;
                        continue;
                    }
                    if (nums[start] + nums[end] == twoSumTarget) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[start++]);
                        temp.add(nums[end--]);
                        res.add(temp);
                        continue;
                    }
                    if (nums[start] + nums[end] < twoSumTarget) start++;
                    if (nums[start] + nums[end] > twoSumTarget) end--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}