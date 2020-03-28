package t892;

public class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length, area = 0;
        if (n == 1) {
            area = 2 + grid[0][0] * 4;
        } else {
            for (int i = 0; i < n; ++i) {
                int yArea = 0;
                int xArea = 0;
                int zArea = 0;
                for (int j = 0; j < n; ++j) {
                    if (j == 0) {
                        yArea += grid[i][j];
                    } else if (j == n - 1) {
                        yArea += grid[i][j];
                        yArea += Math.abs(grid[i][j] - grid[i][j - 1]);
                    } else {
                        yArea += Math.abs(grid[i][j] - grid[i][j - 1]);
                    }
                    if (j == 0) {
                        xArea += grid[j][i];
                    } else if (j == n - 1) {
                        xArea += grid[j][i];
                        xArea += Math.abs(grid[j][i] - grid[j-1][i]);
                    } else {
                        xArea += Math.abs(grid[j][i] - grid[j-1][i]);
                    }
                    if (grid[i][j] != 0) {
                        zArea += 2;
                    }
                }
                area += (xArea + yArea + zArea);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] gird = {{1,2},{3,4}};
        System.out.println(solution.surfaceArea(gird));
    }
}
