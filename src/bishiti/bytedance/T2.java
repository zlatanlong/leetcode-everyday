package bishiti.bytedance;


import java.util.Scanner;

public class T2 {
    public static int dfs(String str, char[] curchars, String changable, int m, int cur, int left) {
        if (m == cur) {
            return maxlen(String.valueOf(curchars), 0, curchars.length - 1);
        }
        int ans = 0;
        for (int i = left + 1; i < changable.length(); i++) {
            if (changable.charAt(i) == '1') {
                curchars[i] = curchars[i - 1];
                ans = Math.max(ans, dfs(str, curchars, changable, m, cur + 1, i));
                curchars[i] = str.charAt(i);

                if (i + 1 < changable.length()) {
                    curchars[i] = curchars[i + 1];
                    ans = Math.max(ans, dfs(str, curchars, changable, m, cur + 1, i));
                    curchars[i] = str.charAt(i);
                }
            }
        }
        return ans;

    }

    public static int t2(String str, String changable, int m) {
        int ans = 0;
        if (m == 0) {
            return maxlen(str, 0, str.length() - 1);
        }
        ans = dfs(str, str.toCharArray(), changable, m, 0, 0);
        return ans;
    }

    //闭区间最大长度
    public static int maxlen(String str, int start, int end) {
        int ans = 0;
        int tmp = 1;
        while (start + 1 <= end) {
            if (str.charAt(start + 1) == str.charAt(start)) {
                tmp++;
            } else {
                ans = Math.max(ans, tmp);
                tmp = 1;
            }
            start++;
        }
        return Math.max(ans, tmp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
            String changable = scanner.nextLine();
            System.out.println(t2(str, changable, m));
        }
//        System.out.println(maxlen("abbaccc", 0, 6));
    }
}
