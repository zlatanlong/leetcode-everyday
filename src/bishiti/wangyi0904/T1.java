package bishiti.wangyi0904;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/9/4 15:03
 */
public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt() % k;
        }
        scanner.nextLine();
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int j = nums[i];
            Integer od = map.getOrDefault(j, 0);
            map.put(j, od + 1);
            ans = Math.max(od + 1, ans);
        }
        System.out.println(ans);
    }
}
