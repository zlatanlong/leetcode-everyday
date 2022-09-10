package bishiti.yongyou;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        String[][] grid = new String[100][];
        while (scanner.hasNextLine()) {
            grid[n++] = scanner.nextLine().split(",");
        }
        int m = grid[0].length;

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j].equals("1")) {
                    max = Math.max(max, dfs(n, m, grid, i, j));
                }
            }
        }
        System.out.println(max);
    }

    static int dfs(int n, int m, String[][] grid, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y].equals("0")) return 0;
        grid[x][y] = "0";
        return 1 + dfs(n, m, grid, x + 1, y) + dfs(n, m, grid, x, y + 1) + dfs(n, m, grid, x - 1, y) + dfs(n, m, grid, x, y - 1);
    }
}
