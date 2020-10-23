package hot100;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/14 22:20
 * 121. 买卖股票的最佳时机
 */
public class T121 {

    public int maxProfit(int[] prices) {
        if (prices.length==0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            if (prices[i] < min) {
                min = prices[i];
            }
        }

        return dp[prices.length-1];

    }

    public static void main(String[] args) {
        System.out.println(new T121().maxProfit(new int[] {7,6,4,3,1}));;
    }
}
