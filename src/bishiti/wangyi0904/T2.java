package bishiti.wangyi0904;

import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/9/4 15:38
 */
public class T2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int t = in.nextInt();
        StringBuilder sb = new StringBuilder(n);
        int count0 = 0;
        int count1 = 0;
        if (k > n || t >= k) {
            System.out.println(-1);
            return;
        } else {
            for (int i = 0; i < t + 1; i++) {
                sb.append('1');
                count1++;
            }
            int liuxiade = k - t - 1;
            boolean flag = false;
            while (sb.length() < n) {
                if (liuxiade > 0 && flag) {
                    liuxiade--;
                    sb.append('1');
                    count1++;
                } else {
                    sb.append('0');
                    count0++;
                }
                flag = !flag;
            }
        }
        if (count1 != k || count0 + count1 != n) {
            System.out.println(-1);
            return;
        }
        System.out.println(sb);
    }

}
