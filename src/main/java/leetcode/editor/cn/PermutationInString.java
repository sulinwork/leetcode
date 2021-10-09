//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 357 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：字符串的排列
public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        // TO TEST
        System.out.println(solution.checkInclusion("ab","eidbaooo"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length();
            int len2 = s2.length();
            if (len1 > len2) return false;
            Map<Character, Integer> cache1 = new HashMap<>();
            Map<Character, Integer> cache2 = new HashMap<>();
            for (char c : s1.toCharArray()) cache1.put(c, cache1.getOrDefault(c, 0) + 1);
            int index = 0;
            while (index <= len2 - len1) {
                char c = s2.charAt(index);
                //不包含直接跳过
                if (cache1.containsKey(c)) {
                    if (cache1.equals(cache2)) return true;
                    cache2.clear();
                } else {
                    cache2.put(c, cache2.getOrDefault(c, 0) + 1);
                }
                index++;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}