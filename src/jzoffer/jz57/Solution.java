package jzoffer.jz57;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 20:56
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int s = nums[l] + nums[r];
            if (s > target) {
                r--;
            } else if (s < target) {
                l++;
            } else {
                return new int[]{nums[l], nums[r]};
            }

        }
        return new int[0];
    }
}
