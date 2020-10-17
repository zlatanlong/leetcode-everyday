package hot100;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/14 18:02
 */
public class T79 {

    int[][] direction = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int m, n;
    boolean[][] flag;
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        // ↑ ← → ↓
        // 行
        m = board.length;
        if (m == 0) {
            return false;
        }
        // 列
        n = board[0].length;
        flag = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }


        return false;
    }

    public boolean dfs(int i, int j, int index) {
        if (!inArea(i, j)) {
            return false;
        }
        if (word.charAt(index) != board[i][j] || flag[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        flag[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nextI = i + direction[k][0];
            int nextJ = j + direction[k][1];
            boolean thisDir = dfs(nextI, nextJ, index + 1);
            // 有一个方向跑通了就返回true
            if (thisDir) {
                return true;
            }
        }
        // 回溯
        flag[i][j] = false;
        return false;
    }

    public boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        System.out.println(new T79().exist(
                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCCED"
        ));
    }

}
