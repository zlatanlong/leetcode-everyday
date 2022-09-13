package bishiti.baidu;

import java.util.HashSet;
import java.util.Scanner;

public class T1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        boolean[] heihei = new boolean[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' ||
                    str.charAt(i) == 'e' ||
                    str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' ||
                    str.charAt(i) == 'u') {
                heihei[i] = true;
            }
        }
        int ans = 0;
        int i = 0;
        while (i <= heihei.length - 5) {
            if (!heihei[i] &&
                    heihei[i + 1] &&
                    heihei[i + 2] &&
                    !heihei[i + 3] &&
                    heihei[i + 4]) {
                if (str.charAt(i) != str.charAt(i + 3) &&
                        str.charAt(i + 1) != str.charAt(i + 2) &&
                        str.charAt(i + 1) != str.charAt(i + 4) &&
                        str.charAt(i + 2) != str.charAt(i + 4)
                ) {
                    ans++;
                }
            }
            i++;
        }
        System.out.println(ans);
    }
}
