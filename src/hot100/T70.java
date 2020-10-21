package hot100;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/21 14:46
 */
public class T70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 1, b = 2;
        for (int i = 0; i < n - 2; i++) {
            int tmp = b;
            b += a;
            a = tmp;
        }
        return b;
    }
}
