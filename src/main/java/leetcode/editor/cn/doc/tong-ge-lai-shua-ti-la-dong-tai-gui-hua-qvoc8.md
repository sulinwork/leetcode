# 动态规划

这道题使用动态规划来解是比较简单的，我们可以观察得到，以nums[i]为结尾的等差数列肯定可以在以nums[i-1]的基础上转换而来，比如，以[1,2,3,4]为例，4结尾的数量是3结尾的数量加1，分别为[1,2,3,4]为在原来[1,2,3]的基础上延续，同时新增了一种[2,3,4]，所以，动态规划定义如下：

**状态定义**：dp[i]表示以nums[i]为结尾的等差数列数量。

**状态转移**：如果nums[i]-nums[i-1]==nums[i-1]-nums[i-2]，dp[i]=dp[i-1]+1，否则dp[i]=0。

另外，dp转移方程只与前一项有关，所以，只需要一个变量即可。

请看代码：

```java
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        int dp = 0, ans = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i]-nums[i-1]==nums[i-1]-nums[i-2]) {
                ans += ++dp;
            } else {
                dp = 0;
            }
        }

        return ans;
    }
}
```

- 时间复杂度：O(n)，遍历一遍数组即可。
- 空间复杂度：O(1)，只需要几个临时变量。

运行结果如下：

![image-20210810101646627.png](https://pic.leetcode-cn.com/1628562469-ZCBrif-image-20210810101646627.png)


# 最后

**如果对你有帮助，请点个赞吧，谢谢^^**

也可以关注我的公号【彤哥来刷题啦】，每日分享题解，一起刷题，一起拿全家桶。







