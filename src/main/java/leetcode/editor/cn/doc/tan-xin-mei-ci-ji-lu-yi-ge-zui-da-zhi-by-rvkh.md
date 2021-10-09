### 解题思路
每次记录一个最大值，然后看当前i和max之前有没有比max更大的值
有就更新max
更新完max之后，ans++

### 代码

```java
class Solution {
    public int jump(int[] nums) {
        int max = 0;
        int ans = 0;
        for(int i = 0;i < nums.length;i++){
            if(max >= nums.length-1) break;
            int tmp = max;
            for(;i <= tmp;i++){
                max = Math.max(max,i+nums[i]);
            }
            i--;
            ans++;
        }
        return ans;
    }
}
```