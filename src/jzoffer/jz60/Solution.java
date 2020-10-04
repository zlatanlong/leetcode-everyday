package jzoffer.jz60;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 13:54
 */
public class Solution {
    public double[] twoSum(int n) {
        int[] dp = new int[6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 6 * n; j >= i; j--) {
                dp[j] = 0;
                for (int k = 1; k <= 6; k++) {
                    // 注意空间优化这里的判断条件，不能是j-k <= 0
                    // i-1表示上一个次第一个数，再往前就是上上次的，不能加到这一次
                    if (j - k < i - 1) {
                        break;
                    }
                    dp[j] += dp[j - k];
                }
            }
        }
        double[] result = new double[n * 5 + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1. * dp[i + n] / Math.pow(6, n);
        }

        return result;
    }
}
