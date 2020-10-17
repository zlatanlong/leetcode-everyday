package problems.t1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/14 15:48
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        int[] minArr = new int[26];
        Arrays.fill(minArr, 101);
        for (int i = 0; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            int[] tmpArr = new int[26];
            Arrays.fill(tmpArr, 0);
            for (char c : chars) {
                tmpArr[c - 'a']++;
            }
            for (int j = 0; j < tmpArr.length; j++) {
                minArr[j] = Math.min(minArr[j], tmpArr[j]);
            }
        }
        ArrayList<String> l = new ArrayList<>();
        for (int i = 0; i < minArr.length; i++) {
            for (int j = 0; j < minArr[i]; j++) {
                l.add(String.valueOf((char) ('a' + i)));
            }
        }
        return l;
    }

    public static void main(String[] args) {
        new Solution().commonChars(new String[] {"bella","label","roller"});
    }
}
