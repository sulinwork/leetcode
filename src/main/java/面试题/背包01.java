package 面试题;

import java.util.Arrays;

public class 背包01 {
    public static void main(String[] args) {
        System.out.println(package02(new int[]{1, 2, 3, 4}, new int[]{2, 4, 4, 5}, 5));
    }


    /**
     * @param weight     每个石头的体积
     * @param value      每个石头的价值
     * @param packageMax 背包最多可以容纳的体积
     * @return
     */
    public static int package01(int[] weight, int[] value, int packageMax) {
        int[][] dp = new int[weight.length][packageMax + 1];
        for (int i = 0; i < packageMax + 1; i++) {
            if (weight[0] < i) dp[0][i] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < packageMax + 1; j++) {
                //j 当前背包的容量
                //weight[i] 装进去需要的容量
                if (weight[i] <= j) {
                    //装的进去  但是装进去也不一定是最优解
                    //故需要在装和不装进去 选择一个最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    //肯定装不进去
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weight.length - 1][packageMax];
    }

    public static int package02(int[] weight, int[] value, int packageMax) {
        int[] dp = new int[packageMax + 1];
        //init 第一次
        for (int i = 0; i < packageMax + 1; i++) {
            if (weight[0] <= i) dp[i] = value[0];
        }
        //状态开始转移
        //一定要倒叙  因为从二维的dp来看   dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]); 中的j - weight[i]
        //必须倒叙才能在一维数组中不覆盖上一次的值
        for (int i = 1; i < weight.length; i++) {
            for (int j = packageMax; j > 0; j--) {
                if (weight[i] <= j) dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[packageMax];
    }
}
