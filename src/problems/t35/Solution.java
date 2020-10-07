package problems.t35;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 12:11
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int m = (start+end)/2;
            if (nums[m]==target) {
                return m;
            }else if (nums[m]<target) {
                start = m+1;
            } else {
                end=m-1;
            }
        }
        return start;
    }
}
