package jzoffer.jz53_2;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 21:48
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int m = (start + end) / 2;
        while (start <= end) {
            if (nums[m] == m) {
                start = m + 1;
            } else {
                end = m - 1;
            }
            m = (start + end) / 2;

        }
        return start;
    }
}
