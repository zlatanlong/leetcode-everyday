package bishiti.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/9/4 20:29
 */
public class T2222 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            boolean flag = false;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
                if (nums[j] == 0) flag = true;
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }

            Arrays.sort(nums);
            if (nums[0] < -1 || nums[n - 1] > 1) {
                System.out.println("NO");
                continue;
            }
            if (!map.containsKey(0)) {
                System.out.println("NO");
                continue;
            }
            map.remove(0);
            int k = 0;
            for (Integer value : map.values()) {
                k = Math.max(k, value);
            }
            if (!map.isEmpty() && k > 1) {

                System.out.println("NO");
            } else {

                System.out.println("YES");
            }
        }
    }
}
