//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 1458 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：LRU 缓存机制
public class LruCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class LRUCache {
        private int capacity;
        private Map<Integer, DoubleLinkNode> cache;
        private DoubleLinkList doubleLinkList = new DoubleLinkList();

        private int len = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>(capacity);
        }

        public int get(int key) {
            if (!cache.containsKey(key)) return -1;
            DoubleLinkNode doubleLinkNode = cache.get(key);
            doubleLinkList.triggerNode(doubleLinkNode);
            return doubleLinkNode.value;
        }

        public void put(int key, int value) {
            //没中
            if (!cache.containsKey(key)) {
                //但是又满了
                if (len == capacity) {
                    DoubleLinkNode doubleLinkNode = doubleLinkList.removeTailNode();
                    cache.remove(doubleLinkNode.key);
                    len--;
                }
                DoubleLinkNode doubleLinkNode = new DoubleLinkNode(key, value);
                doubleLinkList.addHeadNode(doubleLinkNode);
                cache.put(key, doubleLinkNode);
                len++;
                return;
            }
            //中了
            DoubleLinkNode doubleLinkNode = cache.get(key);
            doubleLinkNode.value = value;
            doubleLinkList.triggerNode(doubleLinkNode);
        }
    }

    static class DoubleLinkList {
        private DoubleLinkNode head;
        private DoubleLinkNode tail;
        private int len = 0;

        public DoubleLinkList() {
            head = new DoubleLinkNode(-1, 0);
            tail = new DoubleLinkNode(-2, 0);
            head.next = tail;
            tail.pre = head;
        }

        public DoubleLinkNode removeTailNode() {
            if (len == 0) throw new RuntimeException();
            DoubleLinkNode returnNode = tail.pre;
            DoubleLinkNode preNode = tail.pre.pre;
            preNode.next = tail;
            tail.pre = preNode;
            len--;
            return returnNode;
        }

        public void addHeadNode(DoubleLinkNode node) {
            DoubleLinkNode nextNode = head.next;
            head.next = node;
            node.pre = head;
            node.next = nextNode;
            nextNode.pre = node;
            len++;
        }

        public void triggerNode(DoubleLinkNode node) {
            //remove
            DoubleLinkNode pre = node.pre;
            DoubleLinkNode next = node.next;
            pre.next = next;
            next.pre = pre;
            len--;
            addHeadNode(node);
        }
    }

    static class DoubleLinkNode {
        public DoubleLinkNode pre;
        public DoubleLinkNode next;
        public int value;
        public int key;

        public DoubleLinkNode(int key, int v) {
            this.value = v;
            this.key = key;
        }

        @Override
        public String toString() {
            return "(" + key + "->" + value + ")";
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}