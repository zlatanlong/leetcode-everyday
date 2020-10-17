package problems.t409;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/11 14:20
 */
public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }
        int result = 0;
        int dan = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            result += 2*(entry.getValue() / 2);
            if (dan == 0 && entry.getValue() % 2 == 1) {
                dan = 1;
            }
        }

        return result+dan;
    }
}
