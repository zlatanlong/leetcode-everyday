package problems.t125;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/11 15:02
 */
public class Solution {
    public boolean isPalindrome(String s) {
        int a = 0;
        int b = s.length() - 1;
        while (a < b) {
            if (!(s.charAt(a) >= 'a' && s.charAt(a) <= 'z'
                    || s.charAt(a) >= 'A' && s.charAt(a) <= 'Z'
                    || s.charAt(a) >= '0' && s.charAt(a) <= '9')) {
                a++;
                continue;
            }
            if (!(s.charAt(b) >= 'a' && s.charAt(b) <= 'z'
                    || s.charAt(b) >= 'A' && s.charAt(b) <= 'Z'
                    || s.charAt(b) >= '0' && s.charAt(b) <= '9')) {
                b--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(a++)) != Character.toLowerCase(s.charAt(b--))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("OP"));
    }
}
