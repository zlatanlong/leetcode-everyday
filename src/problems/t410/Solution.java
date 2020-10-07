package problems.t410;

import java.util.Arrays;

public class Solution {
    public int splitArray(int[] nums, int m) {
        long high = Arrays.stream(nums).sum();
        long low = Arrays.stream(nums).max().getAsInt();
        while (low < high) {
            long mid = (high + low) / 2;
            int cnt = 1;
            int subArraySum = 0;
            for (int num : nums) {
                subArraySum += num;
                if (subArraySum > mid) {
                    cnt++;
                    subArraySum = num;
                }
            }
            if (cnt > m) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int) low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2147483646};
        int i = solution.splitArray(a, 2);
        System.out.println(i);
    }
}
