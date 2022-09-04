package bishiti.bytedance;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nm = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nm[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (nm[0][i] > 0) dp[0][i] = nm[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int shangmian = 0;
                int fenshu = +Math.max(nm[i][j], 0);
                boolean flag = false;
                if (nm[i - 1][j] != -1 && dp[i - 1][j] != -2) {
                    shangmian = Math.max(dp[i - 1][j] + fenshu, shangmian);
                    flag = true;
                }
                if (j - 1 >= 0 && nm[i - 1][j - 1] == -1 && dp[i - 1][j - 1] != -2) {
                    shangmian = Math.max(dp[i - 1][j - 1] + fenshu, shangmian);
                    flag = true;
                }
                if (j + 1 <= m - 1 && nm[i - 1][j + 1] == -1 && dp[i - 1][j + 1] != -2) {
                    shangmian = Math.max(dp[i - 1][j + 1] + fenshu, shangmian);
                    flag = true;
                }
                if (!flag) {
                    dp[i][j] = -2;
                } else {
                    dp[i][j] = shangmian;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, dp[n - 1][i]);
        }
        System.out.println(ans);
    }

//    public static int dfs(int[][] nm, int row, int col, int curpoint) {
//        int cur = nm[row][col];
//        if (row == nm.length - 1) {
//            return curpoint + Math.max(cur, 0);
//        }
//        if (cur >= 0 && row + 1 < nm.length) {
//            return dfs(nm, row + 1, col, curpoint + cur);
//        }
//        if (col == 0) {
//            return dfs(nm, row + 1, col + 1, curpoint);
//        } else if (col == nm[0].length-1) {
//            return dfs(nm, row + 1, col - 1, curpoint);
//        }
//        return Math.max(dfs(nm, row + 1, col - 1, curpoint),
//                dfs(nm, row + 1, col + 1, curpoint));
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[][] nm = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                nm[i][j] = scanner.nextInt();
//            }
//        }
//        int ans = 0;
//        for (int i = 0; i < m; i++) {
//            ans = Math.max(dfs(nm,0,i,0), ans);
//        }
//        System.out.println(ans);
//    }
}
