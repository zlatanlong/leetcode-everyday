package jzoffer.jz21;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 20:46
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while (start < end) {
            if (nums[start] % 2 == 0 && nums[end] % 2 == 1) {
                int t = nums[start];
                nums[start] = nums[end];
                nums[end] = t;

            }
            if (nums[start] % 2 == 1) {
                start++;
            }
            if (nums[end] % 2 == 0) {
                end--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4};

        System.out.println(new Solution().exchange(test));
    }
}
