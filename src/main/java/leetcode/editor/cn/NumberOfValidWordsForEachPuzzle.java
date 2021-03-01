//外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。 
//
// 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底： 
//
// 
// 单词 word 中包含谜面 puzzle 的第一个字母。 
// 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。 
// 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"
//（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。 
// 
//
// 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜
//底的单词数目。 
//
// 
//
// 示例： 
//
// 输入：
//words = ["aaaa","asas","able","ability","actt","actor","access"], 
//puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
//输出：[1,1,3,2,4,0]
//解释：
//1 个单词可以作为 "aboveyz" 的谜底 : "aaaa" 
//1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
//3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
//2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
//4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
//没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10^5 
// 4 <= words[i].length <= 50 
// 1 <= puzzles.length <= 10^4 
// puzzles[i].length == 7 
// words[i][j], puzzles[i][j] 都是小写英文字母。 
// 每个 puzzles[i] 所包含的字符都不重复。 
// 
// Related Topics 位运算 哈希表 
// 👍 80 👎 0

package leetcode.editor.cn;

import java.io.FileReader;
import java.util.*;

//Java：猜字谜

/**
 * word 只会是小写字母 不超过26种 可以用每位0/1 表示是否出现过该字符 比如：abc:111 aacc:101 aa:1
 *
 *
 * 列举子集   for (int k = subset; k != 0; k = (k - 1) & puzzleBit) {
 */
public class NumberOfValidWordsForEachPuzzle {
    public static void main(String[] args) {
        Solution solution = new NumberOfValidWordsForEachPuzzle().new Solution();
//        // TO TEST
//        System.out.println(solution.findNumOfValidWords(new String[]{"apple", "pleas", "please"},
//                new String[]{"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"}));
//        int temp = solution.getBit("c");
//        System.out.println("temp:" + temp);
//        for (int i = temp; i != 0; i = (i - 1) & temp) {
//            System.out.println(i);
//        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            Map<Integer, Integer> dict = new HashMap<>();
            for (String word : words) {
                int bit = getBit(word);
                //因为题目：puzzle的长度是7 那么word的二进制1的数量不可以超过7
                if (Integer.bitCount(bit) <= 7)
                    dict.put(bit, dict.getOrDefault(bit, 0) + 1);
            }
            List<Integer> res = new ArrayList<>();
            for (String puzzle : puzzles) {
                int total = 0;
                int puzzleBit = getBit(puzzle);
                int firstBit = getBit(String.valueOf(puzzle.charAt(0)));
                int subset = puzzleBit;
                for (int k = subset; k != 0; k = (k - 1) & puzzleBit) {
                    if ((firstBit & k) != 0) total += dict.getOrDefault(k, 0);
                }
                res.add(total);
            }
            return res;
        }

        public int getBit(String str) {
            char[] chars = str.toCharArray();
            int cur = 0;
            for (char aChar : chars) {
                cur |= 1 << (aChar - 'a');
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}