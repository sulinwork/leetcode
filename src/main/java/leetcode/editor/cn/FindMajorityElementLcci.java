//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1
//) 的解决方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 示例 2： 
//
// 
//输入：[3,2]
//输出：-1 
//
// 示例 3： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2 
// Related Topics 数组 计数 
// 👍 145 👎 0

package leetcode.editor.cn;

//Java：主要元素
public class FindMajorityElementLcci {
    public static void main(String[] args) {
        Solution solution = new FindMajorityElementLcci().new Solution();
        // TO TEST
        int i = solution.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int element = -1;
            int count = 0;
            for (int num : nums) {
                if (num == element) count++;
                else {
                    if (count <= 1) {
                        element = num;
                        count = 1;
                    } else count--;
                }
            }
            count = 0;
            for (int num : nums) {
                if (num == element) count++;
            }
            return (count > (nums.length / 2)) ? element : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}