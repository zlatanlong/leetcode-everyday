package t001_099;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/20 21:29
 */
public class T53 {

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }
}
