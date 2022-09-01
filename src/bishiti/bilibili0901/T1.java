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
        System.out.println(t1.minSum(n));

    }
}
