package bishiti.xhs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/28 15:53
 */
public class T1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] ss1 = s1.split("\\s");
        int n = Integer.parseInt(ss1[0]);
        int m = Integer.parseInt(ss1[1]);
        int id = Integer.parseInt(ss1[2]);
        int[][] nm = new int[n][2];
        for (int i = 0; i < n; i++) {
            String tmp = scanner.nextLine();
            String[] tmparr = tmp.split("\\s");
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += Integer.parseInt(tmparr[j]);
            }
            nm[i][0] = sum;
            nm[i][1] = i+1;
        }

        Arrays.sort(nm, (e1, e2) -> {
            if (e2[0] != e1[0])
                return e2[0] - e1[0];
            else
                return e1[1] - e2[1];
        });

        for (int i = 0; i < n; i++) {
            if (nm[i][1] == id) System.out.println(i+1);
        }
    }
}
