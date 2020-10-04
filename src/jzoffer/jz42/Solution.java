package jzoffer.jz42;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 20:15
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(0, nums[i - 1]);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
