package JavaDevelopmentClassTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T1582 {

    public int numSpecial(int[][] mat) {
        // -1 empty
        // -2 bad
        //  # good
        int m = mat.length;
        int n = mat[0].length;
        int[] colCheck = new int[n];
        Arrays.fill(colCheck, -1);
        Set<Integer> rows = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int rowCheck = -1;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                if (rowCheck != -1) {
                    rowCheck = -2;
                } else {
                    rowCheck = i;
                }
                if (colCheck[j] != -1) {
                    colCheck[j] = -2;
                } else {
                    colCheck[j] = i;
                }
            }
            if (rowCheck >= 0) {
                rows.add(rowCheck);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (colCheck[i] < 0) {
                continue;
            }
            if (rows.contains(colCheck[i])) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
