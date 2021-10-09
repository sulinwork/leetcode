//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 765 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Java：全排列 II
public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        // TO TEST
        //[[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]
        System.out.println(solution.permuteUnique(new int[]{2, 2, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            allSort(nums, 0, res);
            return res;
        }

        public void allSort(int[] nums, int index, List<List<Integer>> res) {
            if (index == nums.length) {
                res.add(arrayToList(nums));
                return;
            }
            HashSet<Integer> cache = new HashSet<>();
            for (int i = index; i < nums.length; i++) {
                if (cache.contains(nums[i])) continue;
                cache.add(nums[i]);
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