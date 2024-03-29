//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 555 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：最大数
public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            Integer[] temp = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                temp[i] = nums[i];
            }
            Arrays.sort(temp, (x, y) -> (y + "" + x).compareTo(x + "" + y));
            if(temp[0]==0) return "0";
            StringBuilder sb = new StringBuilder();
            for (Integer integer : temp) {
                sb.append(integer);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}