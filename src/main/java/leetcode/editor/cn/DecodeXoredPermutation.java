//给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。 
//
// 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说
//，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。 
//
// 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。 
//
// 
//
// 示例 1： 
//
// 输入：encoded = [3,1]
//输出：[1,2,3]
//解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
// 
//
// 示例 2： 
//
// 输入：encoded = [6,5,4,6]
//输出：[2,4,1,5,3]
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n < 105 
// n 是奇数。 
// encoded.length == n - 1 
// 
// Related Topics 位运算 
// 👍 92 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：解码异或后的排列
public class DecodeXoredPermutation {
    public static void main(String[] args) {
        Solution solution = new DecodeXoredPermutation().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.decode(new int[]{6,5,4,6})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] decode(int[] encoded) {
            int l = encoded.length + 1;
            int[] perm = new int[l];
            //求perm的全部异或
            int a = 0;
            for (int i = 1; i <= l; i++) a = a ^ i;
            int b = 0;//通过encoded 计算 出了perm[0]以外的其他异或
            for (int i = 1; i < encoded.length; i += 2) b = b ^ encoded[i];
            perm[0] = a ^ b;
            for (int i = 1; i < perm.length; i++) {
                perm[i] = perm[i - 1] ^ encoded[i - 1];
            }
            return perm;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}