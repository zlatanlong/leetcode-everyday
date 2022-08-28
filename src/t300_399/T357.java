package t300_399;

/**
 * @author zlatanlong
 * @date 2022/4/11 18:17
 */
public class T357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int ans = 10;
        for (int i = 2, last = 9; i <= n; i++) {
            int cur = last * (10 - i + 1);
            ans += cur;
            last = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        new T357().countNumbersWithUniqueDigits(3);
    }
    /**
     * 对于没有要求不重复的
     * 10^3 = 10+90+900
     *      = 一位的情况 + 两位的情况 + 三位的情况  (三位的情况=第三位可能种数 * 后两位可能种数)
     *      = 10 + 9*10 + 9*10*10
     *  ----------------------------------------------
     *  对于有要求不重复的
     *  648 = 10 + 9*9 + 9*9*8
     *
     */
}
