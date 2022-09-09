package bishiti.s360;

import java.util.Scanner;

public class T1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }
        int ans = 0;
        int left;
        int i = 0;
        while (i < n) {
            left = i;
            while (i + 1 < n && nums[i] < nums[i + 1]) {
                i++;
            }
            int tmp = i;
            while (tmp + 1 < n && nums[tmp] > nums[tmp + 1]) {
                tmp++;
            }

            ans = Math.max(tmp - left + 1, ans);
            i++;
        }


        System.out.println(ans);

    }
}
