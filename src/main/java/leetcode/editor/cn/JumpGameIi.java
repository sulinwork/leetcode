//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1086 👎 0

package leetcode.editor.cn;

import java.util.concurrent.atomic.AtomicInteger;

//Java：跳跃游戏 II
public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        // TO TEST
        System.out.println(solution.jump(new int[]{1, 2, 1, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int count = 0;
            int curIndex = 0;
            while (curIndex < nums.length - 1) {
                //System.out.println("坐标：" + curIndex + "->" + nums[curIndex]);
                count++;
                //可以走几步
                int num = nums[curIndex];
                if ((curIndex + num) >= nums.length - 1) {
                    return count;
                }
                int tMax = 0;
                //找到一个最远坐标
                int tIndex = 0;
                for (int i = 1; i <= num && (curIndex + i) < nums.length; i++) {
                    //可以走到哪里
                    int temp = curIndex + i + nums[curIndex + i];
                    if (temp >= nums.length - 1) {
                        tIndex = curIndex + i;
                        break;
                    }
                    //这一步走不完
                    if (temp > tMax) {
                        tMax = temp;
                        tIndex = curIndex + i;
                    }
                }

                curIndex = tIndex;

            }
            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}