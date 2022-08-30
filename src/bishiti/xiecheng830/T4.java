package bishiti.xiecheng830;

import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/30 19:19
 */
public class T4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];

        int lindex = 0, rindex = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        for (int i = 0; i < n - 1; i++) {
            long tmp = Math.abs(nums[i] - nums[i + 1]);
            if (tmp > max) {
                lindex = i;
                rindex = i + 1;
                max = tmp;
            }
        }
        max = 0;
        if (lindex == 0 || rindex == n - 1) {
            if (lindex == 0) {
                nums[0] = nums[1];
            } else {
                nums[n - 1] = nums[n - 2];
            }
            for (int i = 1; i < n; i++) {
                long tmp = Math.abs(nums[i] - nums[i - 1]);
                if (tmp > max) {
                    max = tmp;
                }
            }
            System.out.println(max);
            return;
        }
        if (Math.abs(nums[rindex + 1] - nums[lindex]) >
                Math.abs(nums[lindex - 1] - nums[rindex])) {
            nums[lindex] = (nums[rindex] + nums[lindex - 1]) / 2;
        } else {
            nums[rindex] = (nums[lindex] + nums[rindex + 1]) / 2;
        }
        max = 0;
        for (int i = 1; i < n; i++) {
            long tmp = Math.abs(nums[i] - nums[i - 1]);
            if (tmp > max) {
                max = tmp;
            }
        }
        System.out.println(max);
    }
}
