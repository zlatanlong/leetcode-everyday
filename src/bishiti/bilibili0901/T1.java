package bishiti.bilibili0901;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/9/1 19:49
 */
public class T1 {

    int ans = Integer.MAX_VALUE;

    public void dfs(int cur, int n, int[] curi, int l) {
        if (cur == n) {
            ans = Math.min(ans, Arrays.stream(curi).sum());
            return;
        }

        for (int i = l + 1; i <= n; i++) {
            if (cur * i <= n) {
                curi[i - 1] = i;
                dfs(cur * i, n, curi, i);
                curi[i - 1] = 0;
            }
        }
    }

    /**
     * 思想：首先要解决怎样分解和才最小，对于任何大于2的自然数a, b, 则1/a + 1/b < 1/2 + 1/2 = 1.
     * 所以a + b < ab。所以对于N的任何一个因子m, 若m=ab，
     * 由于m>a+b，所以应该将m分解成a和b。所以和最小的情况是将N分解成所有的素数乘积。
     * @param n
     * @return
     */
    public int minSum(int n) {
        if (1 == n || 2 == n) return n;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                if (minSum(i) == i) {
                    return i + minSum(n / i);
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        T1 t1 = new T1();
        t1.dfs(1, n, new int[n], 1);
        System.out.println(t1.ans);

    }
}
