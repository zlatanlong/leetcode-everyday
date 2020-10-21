package byteDance;

import java.util.Scanner;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/17 22:53
 */
public class Shizi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] jinbi = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            jinbi[i] = in.nextInt();
            if (i == 0) sum[i] = jinbi[i];
            else sum[i] = sum[i - 1] + jinbi[i];
        }
        in.close();
        long temp = 0;
        long min = 0;
        long[][] dp = new long[n][n];
        for (int l = 1; l < n; l++) {//枚举长度,合并次数
            System.out.println("l=" + l);
            for (int i = 0; i < n && i + l < n; i++) { //枚举起点 枚举终点ends<= n-1
                System.out.println("    i=" + i);
                min = dp[i][i] + dp[i + 1][i + l];//最小值
                System.out.println("    dp[i][i]：dp[" + i + "][" + i + "]=" + dp[i][i]);
                System.out.println("    dp[i + 1][i + l]：dp[" + (i + 1) + "][" + (i + l) + "]=" + dp[i + 1][i + l]);
                System.out.println("    min = " + min);
                for (int k = i + 1; k <= i + l - 1; k++) {//枚举分割点
                    System.out.println("        k=" + k);
                    temp = dp[i][k] + dp[k + 1][i + l];//其他步数的最小值
                    System.out.println("        dp[i][k]：dp[" + i + "][" + k + "]=" + dp[i][k]);
                    System.out.println("        dp[k + 1][i + l]：dp[" + (k + 1) + "][" + (i + l) + "]=" + dp[k + 1][i + l]);
                    System.out.println("        temp = " + temp);
                    System.out.println("            temp < min = " + (temp < min));
                    if (temp < min) {
                        min = temp;
                        System.out.println("                min = " + min);
                    }
                }
                System.out.println("        i > 0 =" + (i > 0));
                if (i > 0) {
                    dp[i][i + l] = min + sum[i + l] - sum[i - 1];
                    System.out.println("                min=" + min);
                    System.out.println("                sum[i + l]：sum[" + (i + l) + "]=" + sum[i + l]);
                    System.out.println("                sum[i - 1]：sum [" + (i - 1) + "]= " + sum[i - 1]);
                    System.out.println("                dp[i][i + l]：dp[" + i + "][" + (i + l) + "]=" + dp[i][i + l]);
                } else {
                    dp[i][i + l] = min + sum[l];
                    System.out.println("                min=" + min);
                    System.out.println("                sum[" + l + "]=" + sum[l]);
                    System.out.println("                dp[" + i + "][" + (i + l) + "]=" + dp[i][i + l]);
                }
            }
        }
        System.out.println(dp[0][n - 1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
