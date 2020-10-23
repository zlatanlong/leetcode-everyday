package hot100;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/22 13:44
 */
public class T169 {

    public int majorityElement(int[] nums) {
        Integer curMax = null, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) curMax = nums[i];
            count += nums[i] == curMax ? 1 : -1;
        }
        return curMax;
    }

}
