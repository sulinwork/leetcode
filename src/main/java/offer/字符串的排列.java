package offer;

import java.util.*;


public class 字符串的排列 {
    public static void main(String[] args) {
        Solution solution = new 字符串的排列().new Solution();
        System.out.println(Arrays.toString(solution.permutation("abb")));
    }

    class Solution {
        public String[] permutation(String s) {
            List<String> ret = new ArrayList<>();
            dfs(s.toCharArray(), 0, ret);
            return ret.toArray(new String[ret.size()]);
        }

        public void dfs(char[] array, int index, List<String> ret) {
            if (array.length - 1 == index) {
                ret.add(new String(array));
                return;
            }
            //List<Character> cache = new ArrayList<>();
            Set<Character> cache = new HashSet<>();
            for (int i = index; i < array.length; i++) {
                if (cache.contains(array[i])) continue;
                cache.add(array[i]);
                swap(array, index, i);
                dfs(array, index + 1, ret);
                swap(array, index, i);
            }
        }

        public void swap(char[] array, int i, int j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
