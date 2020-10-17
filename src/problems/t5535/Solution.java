package problems.t5535;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/11 16:25
 */
public class Solution {

    public int maxDepth(String s) {
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                max = Math.max(cnt, max);
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
        }

        return max;
    }
}
