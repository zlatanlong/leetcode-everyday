package problems.t925;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/21 13:51
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = 0, t = 0;
        int nL = name.length(), tL = typed.length();
        while (n <= nL - 1 && t <= tL - 1) {
            if (name.charAt(n) == typed.charAt(t)) {
                n++;
                t++;
            } else if (t > 0 && typed.charAt(t) == typed.charAt(t - 1)) {
                t++;
            } else {
                return false;
            }
        }
        if (n != nL && t == tL) {
            return false;
        } else if (n == nL && t != tL) {
            while (t <= tL - 1) {
                if (t > 0 && typed.charAt(t) != typed.charAt(t - 1)) {
                    return false;
                }
                t++;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isLongPressedName("zi", "zz"));
    }
}
