package mianshi;

import java.util.Arrays;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 11:59
 */
public class MS1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] tmps = Arrays.copyOf(A, A.length);
        int a = 0, b = 0, c = 0;

        while (a < m && b < n) {
            if (tmps[a] < B[b]) {
                A[c++] = tmps[a++];
            } else {
                A[c++] = B[b++];
            }
        }

        while (a < m) {
            A[c++] = tmps[a++];
        }
        while (b < n) {
            A[c++] = B[b++];
        }
    }
}
