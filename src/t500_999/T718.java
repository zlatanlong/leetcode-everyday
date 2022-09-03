package t500_999;

/**
 * 最长重复子数组
 * dp
 * 滑动窗口 类似于卷积
 */
public class T718 {

    /**
     * 暴力法 单纯比较
     */
    public int find(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] == B[j]) {
                    int subLen = 1;
                    while (i + subLen < m && j + subLen < n && A[i + subLen] == B[j + subLen]) subLen++;
                    ans = Math.max(ans, subLen);
                }
            }
        }
        return ans;
    }

    /**
     * dp
     */
    public int findLength2(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n + 1][m + 1]; // dp[i][j]表示以A的前i项与B的前j项的为末尾项的最长重复子数组长度
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }

    public int findLength(int[] A, int[] B) {
        return A.length < B.length ? findMax(A, B) : findMax(B, A);
    }

    int findMax(int[] A, int[] B) {
        int max = 0;
        int an = A.length, bn = B.length;
        // 用A去滑动B  len为相交
        //                          -------- A
        //  -------------------------- B
        for (int len = 1; len <= an; len++) {
            max = Math.max(max, maxLen(A, 0, B, bn - len, len));
        }
        //            -------- A
        //  -------------------------- B
        for (int j = bn - an; j >= 0; j--) {
            max = Math.max(max, maxLen(A, 0, B, j, an));
        }
        //  1-----i----- A
        //        -------------------------- B
        for (int i = 1; i < an; i++) {
            max = Math.max(max, maxLen(A, i, B, 0, an - i));
        }
        return max;
    }

    /**
     * 数组a从i开始, 数组b从j开始 最长 len 的最大连续相同串长度
     * 但是到不了len
     */
    int maxLen(int[] a, int i, int[] b, int j, int len) {
        int count = 0, max = 0;
        for (int k = 0; k < len; k++) {
            if (a[i + k] == b[j + k]) {
                count++;
            } else if (count > 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return count > 0 ? Math.max(max, count) : max;
    }
}
