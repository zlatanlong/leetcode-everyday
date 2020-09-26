package t329;

public class Solution {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        // memo进行有记忆化的dfs
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    /**
     * 计算当前位置可移动的最大距离；
     * 计算时保存在memo数组中，返回值从memo数组中取出
     * @param matrix 初始值数组
     * @param row 行
     * @param column 列
     * @param memo 保存在memo数组里
     * @return 最大距离
     */
    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        // 如果已经计算过路径 就不需要再计算 直接取值，因为每个位置只有一个合理的最大路径
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column]; // 相当于赋值1
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }

}
