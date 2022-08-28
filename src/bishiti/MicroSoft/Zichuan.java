package bishiti.MicroSoft;

import java.util.HashMap;
import java.util.HashSet;

public class Zichuan {


    public static int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cur = 0;
        int ans = 0;
        map.put(0,-1);
        // cur a-z最长26位 int即可
        // 000000000001 表示 'a'出现奇数次
        // 000000000010 表示 'b'出现奇数次
        // cur记录着 当前字符串[0,i]时 'a-z'的奇偶数状态
        for (int i = 0; i < s.length(); ++i) {
            cur ^= (1 << (s.charAt(i) - 'a'));
            if (!map.containsKey(cur)) {
                // 第一次出现当前状态的i
                map.put(cur, i);
            } else {
                // 如果子串 [0，i] 与字串 [0,j] 状态相同，那么字串 [i+1,j] 的状态一定是 0
                ans = Math.max(ans, i - map.get(cur));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Zichuan.findTheLongestSubstring("bdaaadadb")); // 6
        System.out.println(Zichuan.findTheLongestSubstring("abacb")); // 0
        System.out.println(Zichuan.findTheLongestSubstring("zthzth")); // 6

//        System.out.println(Zichuan.solution("zthzth")); // 6
//        System.out.println(Zichuan.solution("bdaaadadb")); // 6
//        System.out.println(Zichuan.solution("abacb")); // 0
    }

    public static int solution(String s) {
        // write your code in Java 8 (Java SE 8)
        int n = s.length();
        int finalRes = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = i; j < n; j++) {
                char charTem = s.charAt(j);
                if (hs.contains(charTem)) {
                    hs.remove(charTem);
                } else {
                    hs.add(charTem);
                }
                if (hs.isEmpty()) {
                    int tem = j - i + 1;
                    finalRes = Math.max(finalRes, tem);
                }
            }
        }
        return finalRes;
    }

}
