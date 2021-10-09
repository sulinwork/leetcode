### 解题思路

- 标签：二分查找
- 过程：
  - 设定左右指针
  - 找出中间位置，并判断该位置值是否等于 target
  - `nums[mid] == target` 则返回该位置下标
  - `nums[mid] > target` 则右侧指针移到中间
  - `nums[mid] < target` 则左侧指针移到中间
- 时间复杂度：*O(logN)*

### 代码

```Java []
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left<=right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
```

### 画解

 ![frame_00001.png](https://pic.leetcode-cn.com/dfa84c120b44d64a9dbdc29f4fc659c4210365c5c03291039c3b1b10df80ac0f-frame_00001.png) ![frame_00002.png](https://pic.leetcode-cn.com/6955159a1a4c167f97955f66abd61e20861089e008dd86b26dc350677fc01a3e-frame_00002.png) ![frame_00003.png](https://pic.leetcode-cn.com/4ec5f9bacd8eda5ec91fb59fe2d937f792dc26a693db57130df010def1a8c859-frame_00003.png) ![frame_00004.png](https://pic.leetcode-cn.com/ca35b04c780fbb06fc640b180932acdfb4d9f58327c4018b59714dfc7cdda6bb-frame_00004.png) ![frame_00005.png](https://pic.leetcode-cn.com/9a153c4da08093f29c52b02c171b67dce8a27ddabba99545e4923d0589132250-frame_00005.png) ![frame_00006.png](https://pic.leetcode-cn.com/506b8c5a1fd8cb3d740e75e5274360bb1d90bff0d41c5850eec78a5480425b23-frame_00006.png) ![frame_00007.png](https://pic.leetcode-cn.com/277fb8c85cd3794e436b0be2470d12b3581cfbedfbc5512d76cc62e7f68cfc99-frame_00007.png) 

想看大鹏画解更多高频面试题，欢迎阅读大鹏的 LeetBook：[《画解剑指 Offer 》](https://leetcode-cn.com/leetbook/detail/illustrate-lcof/)，O(∩_∩)O