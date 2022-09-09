package bishiti.jingdong;

import java.util.Scanner;

public class T1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ans = 0;
        int i = 1;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ans++;
                i++;
            }
        }
        System.out.println(ans);
    }
}
