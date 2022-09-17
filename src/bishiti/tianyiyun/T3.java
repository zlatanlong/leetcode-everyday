package bishiti.tianyiyun;

import java.util.Scanner;

public class T3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tili = scanner.nextInt();
        int n = scanner.nextInt();
        int[] points = new int[n];
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = scanner.nextInt();
        }
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextInt();
        }

        int[] dp = new int[tili+1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = tili; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j] , dp[j - cost[i]] + points[i]);
            }
        }
        System.out.println(dp[tili]);

    }
}
