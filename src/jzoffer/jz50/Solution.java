package jzoffer.jz50;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 12:51
 */
public class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> show = new HashMap<>();
        char[] chars = s.toCharArray();
        char res = ' ';
        Integer value = Integer.MAX_VALUE;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (show.containsKey(chars[i])) {
                show.put(chars[i], Integer.MAX_VALUE);
            } else {
                show.put(chars[i], i);
            }
        }
        for (Map.Entry<Character, Integer> c : show.entrySet()) {
            if (c.getValue()<value) {
                value = c.getValue();
                res = c.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("cc"));
    }
}
