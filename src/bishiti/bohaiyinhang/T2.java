package bishiti.bohaiyinhang;

import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/9/13 16:44
 */
public class T2 {
    public static boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k < i) {
                return false;
            }
            k = Math.max(i + nums[i], k);
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i <n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(canJump(nums));
    }
}
