package bishiti.jingweihengrun;

import bishiti.xiaomi0920.T2;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class T1 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @return bool布尔型
     */
    public boolean isValid(String str) {
        if (str.length() != 12) return false;
        String[] split = str.split("-");
        if (split.length != 3) return false;
        if (split[0].length() != 3) return false;
        if (split[1].length() != 3) return false;
        if (split[2].length() != 4) return false;
        for (String s : split) {
            for (char c : s.toCharArray()) {
                if (c > '9' || c < '0') return false;
            }
        }
        return true;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param S string字符串
     * @param T string字符串
     * @return string字符串
     */
    public String minWindow(String S, String T) {
        HashSet<Character> set = new HashSet<>();
        for (char c : T.toCharArray()) {
            set.add(c);
        }
        int left = 0;
        int idx = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        String ans = "";
        while (idx < S.length()) {
            char c = S.charAt(idx);
            if (set.contains(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            if (map.size() == set.size()) {
                int l = left;
                while (map.size() != set.size() - 1 && l < idx) {
                    char lc = S.charAt(l);
                    if (set.contains(lc)) {
                        int count = map.get(lc);
                        if (count == 1) {
                            map.remove(lc);
                        } else {
                            map.put(lc, count - 1);
                        }
                    }
                    l++;
                }
                left = l;
                if (min > idx - left + 1) {
                    ans = S.substring(left - 1, idx + 1);
                    min = idx - left + 1;
                }
            }
            idx++;
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new T1().minWindow("XDOYEZODEYXNZ", "XYZ"));
    }

}
