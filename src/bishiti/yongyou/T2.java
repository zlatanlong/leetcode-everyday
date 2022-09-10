package bishiti.yongyou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T2 {


    public static int dfs(int[][] mn, int row, int col) {
        if (row < 0 || col < 0 || row >= mn.length || col >= mn[0].length || mn[row][col] != 1) {
            return 0;
        }
        mn[row][col] = 0;
        int num = 1;
        num += dfs(mn, row + 1, col);
        num += dfs(mn, row - 1, col);
        num += dfs(mn, row, col + 1);
        num += dfs(mn, row, col - 1);
        return num;
    }


    public static void main(String[] args) throws IOException {

//        Scanner scanner = new Scanner(System.in);
        String str = null;
        List<String> inputs = new ArrayList<>();
//        while (!(str = scanner.nextLine()).equals("")) {
//            inputs.add(str);
//        }
        BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));
        while (!(str =KEYBOARD_INPUT.readLine()).equals("")) {
                inputs.add(str);
        }
        int m = inputs.size();
        int n = inputs.get(0).split(",").length;
        int[][] mn = new int[m][n];
        for (int i = 0; i < inputs.size(); i++) {
            String[] split = inputs.get(i).split(",");
            for (int j = 0; j < n; j++) {
                mn[i][j] = Integer.parseInt(split[j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mn[i][j] == 1) {
                    ans = Math.max(ans, dfs(mn, i, j));
                }
            }
        }
        System.out.println(ans);
    }
}
