package hot100;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/15 17:45
 */
public class T136 {

    /**
     * 用异或找不同，跪了
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

}
