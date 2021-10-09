//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 252 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：有效三角形的个数
public class ValidTriangleNumber {
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
        // TO TEST
        System.out.println(solution.triangleNumber(new int[]{48, 66, 61, 46, 94, 75}));
        //System.out.println(solution.isTriangle(48,46,94));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int triangleNumber(int[] nums) {
            if (nums == null || nums.length < 3) return 0;
            int res = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int twoSum = nums[i] + nums[j];
                    int k = nums.length - 1;
                    while (k > j) {
                        if (nums[k] < twoSum) {
                            res += k - j;
                            break;
                        } else k--;
                    }
                }
            }
            return res;
        }

        public boolean isTriangle(int a, int b, int c) {
            return (a + b > c) && (a + c > b) && (b + c > a);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}