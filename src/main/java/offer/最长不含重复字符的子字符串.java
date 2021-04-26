package offer;

import java.util.HashMap;
import java.util.Map;

public class 最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        Solution solution = new 最长不含重复字符的子字符串().new Solution();
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || "".equals(s)) return 0;
            if (s.length() == 1) return 1;
            Map<Character, Integer> dic = new HashMap<>();
            int i = -1, res = 0;
            for(int j = 0; j < s.length(); j++) {
                if(dic.containsKey(s.charAt(j)))
                    i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
                dic.put(s.charAt(j), j); // 哈希表记录
                res = Math.max(res, j - i); // 更新结果
            }
            return res;
        }
    }
}
