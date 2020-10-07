package jzoffer.jz03;

import java.util.HashMap;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 17:40
 */
public class Solution {

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Object> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            }else {
                map.put(num,null);
            }
        }
        return 0;
    }

}
