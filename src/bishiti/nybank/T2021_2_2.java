package bishiti.nybank;

import java.util.HashMap;
import java.util.Map;

public class T2021_2_2 {
    HashMap<Character, Integer> map = new HashMap<>();

    public boolean shifoubaohan(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s1.length(); i++) {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }

        outer:
        for (int i = s1.length(); i <= s2.length(); i++) {
            boolean flag = false;
            for (Integer j : map.values()) {
                if (j != 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return true;

            if (i == s2.length()) return false;

            char c = s2.charAt(i - s1.length());
            map.put(c, map.getOrDefault(c, 0) - 1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        T2021_2_2 t = new T2021_2_2();
        System.out.println(t.shifoubaohan("jbc", "cabareer"));
    }
}
