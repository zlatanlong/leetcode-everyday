package jzoffer.jz39;

import java.util.HashMap;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 18:11
 */
public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.compute(nums[i], (k, v) -> ++v);
            } else {

            map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new Solution().majorityElement(test));
    }

}
