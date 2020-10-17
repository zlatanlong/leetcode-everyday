package problems.t14;

import java.util.Arrays;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/11 13:48
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
        int l = Math.min(strs[0].length(),strs[strs.length-1].length());
        for (int i = 0; i < l; i++) {
            if (strs[0].charAt(i)==strs[strs.length-1].charAt(i)) {
                result.append(strs[0].charAt(i));
            }else {
                break;
            }
        }
        return result.toString();
    }

}
