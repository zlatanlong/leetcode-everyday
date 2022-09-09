package bishiti.s360;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class T2 {
    public static int qiu(StringBuilder sb) {
        int tmp;
        char[] chars = sb.toString().toCharArray();
        int idx = 0;
        boolean lastcheng = false;
        Deque<Integer> stack = new LinkedList<>();
        while (idx < chars.length) {
            tmp = 0;
            while (idx < chars.length && chars[idx] >= '0' && chars[idx] <= '9') {
                tmp = tmp * 10 + (chars[idx] - '0');
                idx++;
            }
            char sign;
            if (lastcheng) stack.addLast(stack.removeLast() * tmp);
            else stack.addLast(tmp);
            if (idx >= chars.length) {
                break;
            }
            sign = chars[idx];
            if (sign == '+') {
                lastcheng = false;
            } else if (!lastcheng) {
                lastcheng = true;
            }
            idx++;
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.removeLast();
        }

        return ans;
    }

    public static String yn(String req) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        boolean foundEqual = false;

        for (int i = 0; i < req.length(); i++) {
            if (foundEqual) {
                str2.append(req.charAt(i));
                continue;
            }
            if (req.charAt(i) == '=') {
                foundEqual = true;
                continue;
            }
            str1.append(req.charAt(i));
        }
        int q1 = qiu(str1);
        int q2 = qiu(str2);
        if (q1 == q2) return "Yes";
        // 直接他妈的暴力
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= str1.length(); j++) {
                String nsb;
                nsb = str1.substring(0,j) + i + str1.substring(j,str1.length());
                if (q2 == qiu(new StringBuilder(nsb))) return "Yes";
            }

            for (int j = 0; j <= str2.length(); j++) {
                String nsb;
                nsb = str2.substring(0,j) + i + str2.substring(j,str2.length());
                if (q1 == qiu(new StringBuilder(nsb))) return "Yes";
            }
        }

        return "No";
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println(yn(scanner.nextLine()));
        }

//        System.out.println(qiu(new StringBuilder("1+2*3")));
//        System.out.println(qiu(new StringBuilder("2*3*4*2*2")));
//        System.out.println(qiu(new StringBuilder("1+2+3")));
//        System.out.println(qiu(new StringBuilder("1*2+3*6")));

    }
}
