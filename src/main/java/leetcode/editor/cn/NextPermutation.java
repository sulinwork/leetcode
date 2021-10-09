//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1211 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：下一个排列
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        // TO TEST
        int[] array = {2, 3,1};
        solution.nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            //尽可能找到num[k]<num[k+1] k的位置尽可能靠右边
            int k = -1;
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] < nums[i + 1]) k = i;
            }
            if (k == -1) {
                reserve(nums, 0, nums.length - 1);
                return;
            }
            //在[k,nums.length]内找到比nums[k]大 但是尽可能最小的 j
            int j = -1;
            for (int i = nums.length - 1; i > k; i--) {
                if (nums[i] > nums[k]) {
                    j = i;
                    break;
                }
            }
            swap(nums, k, j);
            reserve(nums, k + 1, nums.length - 1);
        }


        public void reserve(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        public void swap(int[] nums, int start, int end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}