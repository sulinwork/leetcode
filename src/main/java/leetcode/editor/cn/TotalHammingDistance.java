//两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。 
//
// 计算一个数组中，任意两个数之间汉明距离的总和。 
//
// 示例: 
//
// 
//输入: 4, 14, 2
//
//输出: 6
//
//解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
//所以答案为：
//HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 
//2 + 2 = 6.
// 
//
// 注意: 
//
// 
// 数组中元素的范围为从 0到 10^9。 
// 数组的长度不超过 10^4。 
// 
// Related Topics 位运算 
// 👍 172 👎 0

package leetcode.editor.cn;

/*
	总结
	1.  思路是:
		比如有3个数(用二进制表示) (方向从右到左<-，分别为第1位、第2位...)
			第一个数 a: 1 0 0 1
			第二个数 b: 0 1 1 1
			第三个数 c: 0 0 1 1
		那么第一位上的汉明距离总和是0。
			为什么？ 因为a、b、c该位全是"1"，任意两个"1"的汉明距离是0，所以该位汉明距离总和是0。
		接下来看第二位，a的第二位是"0"，b、c的是"1"，此时该位的汉明距离就是2。
			为什么？ 由上面我们可以得到，该位的"0"有1个，"1"有2个，而任意一个"0"都可以和任意一个"1"组合，
					 一对组合可以产生的汉明距离为1，所以问题转换为了算多少对01组合，那么怎么计算呢？
					 答案就是该位"0"的个数乘以"1"的个数。
		接下来看第三位，可以看出，此时"0"有2个，"1"有1个，所以可以产生的汉明距离为2。
		接下来看第四位，可以看出，此时"0"有2个，"1"有1个，所以可以产生的汉明距离为2。
		于是: 总的汉明距离就是 0 + 2 + 2 + 2 = 6
*/
public class TotalHammingDistance {
    public static void main(String[] args) {
        Solution solution = new TotalHammingDistance().new Solution();


        System.out.println(solution.totalHammingDistance(new int[]{4, 14, 2}));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int sum = 0;
            for (int i = 0; i < 30; i++) {
                int zeroCount = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (((nums[j] >> i) & 1) != 1) zeroCount++;
                }
                sum += zeroCount * (nums.length - zeroCount);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}