package jzoffer.jz04;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 12:56
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n==0) {
            return false;
        }
        int m = matrix[0].length;
        if (m==0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][m-1] < target) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    break;
                }
            }
            if (matrix[i][0] > target) {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = {{1}};
        boolean numberIn2DArray = solution.findNumberIn2DArray(test,1);
        System.out.println(numberIn2DArray);
    }
}
