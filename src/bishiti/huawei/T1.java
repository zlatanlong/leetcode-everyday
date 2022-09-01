package bishiti.huawei;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/31 20:18
 */
public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        HashMap<String, Integer> indexMap = new HashMap<>();
        // 构建 index map
        StringBuilder tmp = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < s2.length(); i++) {

            if (s2.charAt(i) != ' ') {
                if (s2.charAt(i) >= 'A' && s2.charAt(i) <= 'Z') {
                    tmp.append((char) (s2.charAt(i) - 'A' + 'a'));
                } else {
                    tmp.append(s2.charAt(i));
                }
            } else {
                indexMap.put(tmp.toString(), idx++);
                tmp = new StringBuilder();
            }

        }

        StringBuilder ans = new StringBuilder();
        int flag = 0;
        tmp = new StringBuilder();
        for (char c : s1.toCharArray()) {
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
                tmp.append(c);
            } else {
                String res = tmp.toString().toLowerCase(Locale.ROOT);
                if (flag == 0 && indexMap.containsKey(res)) {
                    tmp = new StringBuilder(String.valueOf(indexMap.get(res)));
                }
                ans.append(tmp).append(c);
                tmp = new StringBuilder();
            }
            if (c == '"') {
                flag ^= 1;
            }
        }
        System.out.println(ans);
    }
}
