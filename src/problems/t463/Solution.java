package problems.t463;

/**
 * Solution
 */
public class Solution {

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean shang = i > 0 && grid[i - 1][j] == 1;
                boolean zuo = j > 0 && grid[i][j - 1] == 1;
                if (grid[i][j] == 1) {

                    if (shang && zuo) {
                    } else if (shang || zuo) {
                        ans += 2;
                    } else {
                        ans += 4;
                    }
                }
            }
        }
        return ans;
    }
}