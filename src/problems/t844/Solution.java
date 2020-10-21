package problems.t844;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/19 23:00
 */
public class Solution {

    public boolean backspaceCompare(String S, String T) {
        int s = S.length() - 1;
        int t = T.length() - 1;

        while (true) {
            int sBackTime = 0;
            int tBackTime = 0;
            // 在s,t 大于等于0时， charAt不会越界
            while (s >= 0 && (S.charAt(s) == '#' || sBackTime != 0)) {
                if (S.charAt(s) == '#') {
                    sBackTime++;
                } else {
                    sBackTime--;
                }
                s--;
            }

            while (t >= 0 && (T.charAt(t) == '#' || tBackTime != 0)) {
                if (T.charAt(t) == '#') {
                    tBackTime++;
                } else {
                    tBackTime--;
                }
                t--;
            }
            // 为下面charAt排除越界情况
            if (s == -1 && t == -1) {
                return true;
            } else if (s == -1 || t == -1) {
                return false;
            }
            if (S.charAt(s) != T.charAt(t)) {
                return false;
            }
            s--;
            t--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("a##","###"));
    }
}
