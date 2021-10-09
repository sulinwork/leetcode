//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1482 👎 0

package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//Java：全排列
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        // TO TEST
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            allSort(nums, 0, res);
            return res;
        }

        public void allSort(int[] nums, int index, List<List<Integer>> res) {
            if (index == nums.length) {
                res.add(arrayToList(nums));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                allSort(nums, index + 1, res);
                //回溯
                swap(nums, index, i);
            }
        }

        public void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        public List<Integer> arrayToList(int[] nums) {
            List<Integer> arrayList = new ArrayList<>();
            for (int num : nums) {
                arrayList.add(num);
            }
            return arrayList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}