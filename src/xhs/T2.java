package xhs;

import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/28 16:21
 */
public class T2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] ss1 = s1.split("\\s");
        int n = Integer.parseInt(ss1[0]);
        double K = Double.parseDouble(ss1[1]);
        String s2 = scanner.nextLine();
        String[] ss2 = s2.split("\\s");
        int[] aarr = new int[n];
        for (int i = 0; i < aarr.length; i++) {
            aarr[i] = Integer.parseInt(ss2[i]);
        }
        int ans = 0;
        for (int i = 0; i < aarr.length; i++) {
            for (int j = 0; j < aarr.length; j++) {
                if (i != j && K / aarr[i] <= aarr[j]) {
                    ans++;
//                    System.out.println(aarr[i] + " " + aarr[j]);
                }
            }
        }

        System.out.println(ans);
    }
}
