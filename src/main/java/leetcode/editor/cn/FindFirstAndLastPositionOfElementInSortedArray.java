//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1120 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[]{-1, -1};
            int index = search(nums, target, 0, nums.length - 1);
            if (index == -1) return new int[]{-1, -1};
            System.out.println(index);
            int start = index;
            int end = index;
            while (
                    (start-1>=0 && nums[start-1]==nums[index])
                    ||
                            (end+1<=nums.length-1 && nums[end+1]==nums[index])
            ) {
                if (start-1>=0 && nums[start-1]==nums[index]) start--;
                if (end+1<=nums.length-1 && nums[end+1]==nums[index]) end++;
            }
            return new int[]{start, end};
        }

        public int search(int[] nums, int target, int start, int end) {
            if (start == end && nums[start] != target) return -1;
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) return search(nums, target, start, mid);
            else return search(nums, target, mid + 1, end);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}