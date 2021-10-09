//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 109 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Java：最小K个数
public class SmallestKLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestK(int[] arr, int k) {
            TopK<Integer> integerTopK = new TopK<>(k);
            for (int i : arr) {
                integerTopK.add(i);
            }
            return integerTopK.priorityQueue.stream().mapToInt(e->e.intValue()).toArray();
        }
    }

    static class TopK<E extends Comparable> {
        public PriorityQueue<E> priorityQueue;
        private int maxLen;

        public TopK(int maxLen) {
            this.maxLen = maxLen;
            priorityQueue = new PriorityQueue<>(maxLen);
        }

        public void add(E e) {
            if (priorityQueue.size() >= maxLen) {
                priorityQueue.poll();
            }
            priorityQueue.add(e);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}