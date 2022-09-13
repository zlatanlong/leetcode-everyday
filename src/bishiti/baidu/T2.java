package bishiti.baidu;

import java.util.Scanner;

public class T2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = n - 1; i >= 2; i--) {
            int a = nums[i] / 3;
            int b = nums[i - 1] / 2;
            int c = nums[i - 2];
            int beishu = Math.min(a, Math.min(b, c));
            if (beishu <= 0) continue;
            ans += 5 * beishu;
            nums[i] -= 3 * beishu;
            nums[i - 1] -= 2 * beishu;
            nums[i - 2] -= beishu;

        }
        for (int i = 0; i < n; i++) {
            ans += nums[i];
        }
        System.out.println(ans);

    }
}
