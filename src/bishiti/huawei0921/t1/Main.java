package bishiti.huawei0921.t1;

import java.util.Scanner;

public class Main {


    public static boolean yanzheng(String str) {
        return tel(str) || sip(str);
    }


    public static boolean tel(String str) {
        if (!str.startsWith("tel:")) {
            return false;
        }
        return isTelNum(str.substring(4));
    }


    public static boolean sip(String str) {
        if (!str.startsWith("sip:")) {
            return false;
        }
        String raw = str.substring(4);
        String[] splits = raw.split("@");
        if (splits.length != 2) {
            return false;
        }
        if (!isTelNum(splits[0]) && !isUserinfo(splits[0])) return false;
        return isDomain(splits[1]);
    }

    public static boolean isTelNum(String str) {
        if (!str.startsWith("+")) return false;
        int numCount = 0;
        for (int i = 1; i < str.length(); i++) {
            boolean tmp = isNum(str.charAt(i));
            if (i == 1 && !tmp) return false;
            if (i == str.length() - 1 && !tmp) return false;
            if (!tmp && str.charAt(i) != '-') return false;
            if (!tmp && str.charAt(i - 1) == '-') return false;
            if (tmp) numCount++;
        }
        return numCount >= 6;
    }

    public static boolean isUserinfo(String str) {
        if (str.length() < 6) return false;
        return isChar(str.charAt(0));
    }

    public static boolean isDomain(String str) {
        String[] splits = str.split("\\.");
        if (splits.length < 2) return false;
        for (String s : splits) {
            if (s.length() == 0) return false;
        }
        return true;
    }

    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isChar(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print(yanzheng(scanner.nextLine()) ? '1' : '0');
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}
