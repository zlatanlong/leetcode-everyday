package problems.t763;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/22 12:25
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        char[] chars = S.toCharArray();
        int right = -1;
        int left = 0;
        int[] last = new int[26];
        for (int i = 0; i < chars.length; i++) {
            last[chars[i] - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            right = Math.max(last[chars[i] - 'a'], right);
            if (i == right) {
                list.add(right - left + 1);
                left = right + 1;
            }
        }

        return list;
    }
}
