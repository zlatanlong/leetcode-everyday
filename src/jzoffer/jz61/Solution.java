package jzoffer.jz61;

import java.util.Arrays;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 19:31
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i + 1] - nums[i];
                if (tmp == 0) {
                    return false;
                }
                count += tmp;
            }
        }
        return count <= 4;
    }
}
