package bishiti.meituan827;

import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/27 15:41
 */
public class T1 {

    public int solution(int m, int n, String str1, String str2) {
        int ans = 0;
        for (int i = 0; i <= m - n; i++) {
            if (isPick(str1.substring(i, i + n), str2)) ans++;
        }
        return ans;
    }

    public boolean isPick(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str2.charAt(i) == '*') continue;
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("\\s");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(new T1().solution(m, n, str1, str2));
//        System.out.println(new T1().solution(7, 3, "abcaacc", "a*c"));
    }
}
