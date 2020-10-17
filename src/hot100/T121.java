package hot100;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/14 22:20
 * 121. 买卖股票的最佳时机
 */
public class T121 {

    public int maxProfit(int[] prices) {
        int l = 0;
        int r = prices.length - 1;
        int max = 0, min = Integer.MAX_VALUE;
        while (l < r) {
            if (prices[l] < min) {
                min = prices[l];
            }
            if (prices[r] > max) {
                max = prices[r];
            }
            l++;
            r--;
        }
        return max - min > 0 ? max - min : 0;

    }

    public static void main(String[] args) {
        new T121().maxProfit(new int[] {7,1,5,3,6,4});
    }
}
