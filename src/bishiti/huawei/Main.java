package bishiti.huawei;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/31 18:47
 */
public class Main {
    boolean inDoubleYinhao = false;
    int lastYinHaoIndex;

    public String panduan(String oristr, Map<String, Integer> indexMap, int i) {
        if (oristr.length()==0) {
            return "";
        }
        if (oristr.charAt(0) == '"') {
            inDoubleYinhao = true;
            lastYinHaoIndex = i;
        }
        String thisRound = "";
        if (inDoubleYinhao) {
            thisRound = oristr;
        } else {
            int p1 = 0, p2 = oristr.length() - 1;
            String tmp = "";
            while (p1 <= p2) {
                if (oristr.charAt(p1) != ',' && oristr.charAt(p1) != '.') {
                    tmp += oristr.charAt(p1);
                }
                if (oristr.charAt(p1) == ',') {
                    if (indexMap.containsKey(tmp.toLowerCase(Locale.ROOT))) {
                        thisRound += indexMap.get(tmp.toLowerCase(Locale.ROOT));
                    } else {
                        thisRound += tmp;
                    }
                    thisRound += ",";
                    tmp = "";
                }
                if (oristr.charAt(p1) == '.') {
                    if (indexMap.containsKey(tmp.toLowerCase(Locale.ROOT))) {
                        thisRound += indexMap.get(tmp.toLowerCase(Locale.ROOT));
                    } else {
                        thisRound += tmp;
                    }
                    thisRound += ".";
                    tmp = "";
                }
                if (p1 == p2) {
                    if (indexMap.containsKey(tmp.toLowerCase(Locale.ROOT))) {
                        thisRound += indexMap.get(tmp.toLowerCase(Locale.ROOT));
                    } else {
                        thisRound += tmp;
                    }
                }
                p1++;
            }// while扩回
        }
        // 双引号扩回
        if (i != lastYinHaoIndex && inDoubleYinhao
                && oristr.charAt(oristr.length() - 1) == '"')
            inDoubleYinhao = false;
        return thisRound;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] partten = scanner.nextLine()
                .toLowerCase(Locale.ROOT).split("\\s");
        HashMap<String, Integer> indexMap = new HashMap<>();
        // 构建 index map
        for (int i = partten.length - 1; i >= 0; i--) {
            if (!indexMap.containsKey(partten[i])) {
                indexMap.put(partten[i], i);
            }
        }
        String[] oristrs = s.split("\\s");
        boolean inDoubleYinhao = false;
        int lastYinHaoIndex = 0;
        int pp1 = 0;
        Main t1 = new Main();
        String ans = "";
        String dc = "";
        while (pp1 < s.length()) {
            if (s.charAt(pp1) == ' ') {
                ans += t1.panduan(dc, indexMap, pp1) + " ";
                dc = "";
            } else {
                dc += s.charAt(pp1);
            }
            pp1++;
        }
        ans += t1.panduan(dc, indexMap, pp1);
        System.out.println(ans);
    }
}
