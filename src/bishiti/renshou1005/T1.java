package bishiti.renshou1005;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class T1 {

    static boolean ans = false;
    static HashSet<String> set = new HashSet<>();
    static String s = "";

    public static void bijiao(int start) {
        if (ans) return; // 之前有成功的快速返回
        for (String s1 : set) {
            if (start + s1.length() > s.length()) continue; //长度超了不要
            if (s.substring(start).startsWith(s1)) { // 匹配到一种情况
                if (start + s1.length() == s.length()) { // 已经匹配到最后了，成功
                    ans = true;
                    return;
                }
                bijiao(start + s1.length()); //继续往后匹配
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        String rawWords = scanner.nextLine();
        String[] words = rawWords.split(",");
        Collections.addAll(set, words);
        int i = 0;
        bijiao(0);
        System.out.println(ans);
    }
}
