package jzoffer.jz53_1;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 20:09
 */
public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m, count = 0;

        while (l <= r) {
            m = (l + r) / 2;
            if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (r >= 0 && nums[r] != target) return 0;
        // 此时l应该是右边界
        l--;
        while (l >= 0 && nums[l] == target) {
            l--;
            count++;
        }

        return count;
    }
}
