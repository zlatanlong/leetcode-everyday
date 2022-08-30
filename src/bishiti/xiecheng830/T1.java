package bishiti.xiecheng830;

import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/30 19:28
 */
public class T1 {

    public static String chongpai(String x) {
        if (Integer.parseInt(x) % 2 == 0) return x;
        if (x.length() == 1) return "-1";
        char[] chars = x.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '2' ||
                    chars[i] == '4' ||
                    chars[i] == '6' ||
                    chars[i] == '8' ||
                    chars[i] == '0'
            ) {
                return x.substring(0, i) + x.substring(i + 1, x.length()) + chars[i];
            }
        }


        return "-1";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            int nnn = sc.nextInt();
            strs[i] = String.valueOf(nnn);
        }
        for (int i = 0; i < n; i++) {
            String tmp = strs[i];
            int len = tmp.length();
            char end = tmp.charAt(len - 1);
            if (end == '2' ||
                    end == '4' ||
                    end == '6' ||
                    end == '8' ||
                    end == '0') {
                System.out.println(tmp);
                continue;
            }
            int count = 0;
            for (int j = len - 1; j >= 0; j--) {
                char c = tmp.charAt(j);
                if (c == '2' ||
                        c == '4' ||
                        c == '6' ||
                        c == '8' ||
                        c == '0') {
                    count++;
                }
                if (count == 1) {
                    int i1 = Integer.parseInt(tmp.substring(0, j) + tmp.substring(j + 1, len) + c);
                    System.out.println(i1);
                    break;
                }
            }
            if (count == 0) {
                System.out.println("-1");
            }
        }
    }
}
