package bishiti.tianyiyun;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] nums = new int[n][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] c = scanner.nextLine().split(",");
            for (int j = 0; j < 2; j++) {
                nums[i][j] = Integer.parseInt(c[j]);
                if (j == 1) {
                    max = Math.max(max, nums[i][j]);
                }
            }
        }
        int[] flags = new int[max + 1];
        for (int i = 0; i < n; i++) {
            for (int j = nums[i][0]; j < nums[i][1]; j++) {
                flags[j]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < flags.length; i++) {
            if (flags[i]==1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
