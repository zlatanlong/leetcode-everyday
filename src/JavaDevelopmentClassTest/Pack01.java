package JavaDevelopmentClassTest;

import java.util.Scanner;

public class Pack01 {

  public static void main(String[] args) {
    Thing[] things = new Thing[101];
    int s, n; // 背包容量和总数
    s = 1;
    n = 1;
    int[][] dp = new int[100][1001];
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i <= n; i++) {
      things[i].w = scanner.nextInt();
      things[i].v = scanner.nextInt();
    }
    for (int i = 0; i <= s; i++)
      dp[0][i] = 0; // 初始化第一行
    for (int i = 1; i <= n; i++) {
      // 这里是反序遍历
      for (int j = s; j >= things[i].w; j--) {
        // ！状态转移方程
        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - things[i].v] + things[i].v);
      }
      for (int j = things[i].w - 1; j >= 0; j--) {
        dp[i][j] = dp[i - 1][j];
      }
    }
    scanner.close();
  }

}

class Thing {
  public int w;
  public int v;
}