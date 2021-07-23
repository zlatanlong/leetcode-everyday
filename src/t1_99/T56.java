package t1_99;

import java.util.Arrays;

public class T56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] ans = new int[intervals.length][2];
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (index == -1 || intervals[i][0] > ans[index][1]) {
                ans[++index] = intervals[i];
                continue;
            }
            if (intervals[i][1] < ans[index][1]) {
                continue;
            } else {
                ans[index][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(ans, index + 1);
    }
}
