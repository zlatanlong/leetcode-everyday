package bishiti.baidu;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class T33 {


    public static void main(String[] args) {
//        String ttt = "import java.util.*;\n" +
//                "\n" +
//                "public class Main{\n" +
//                "    public static void main(String[] args){\n" +
//                "        Scanner in = new Scanner(System.in);\n" +
//                "        int a = 0 , b = 0;\n" +
//                "        int n = in.nextInt();\n" +
//                "        for (int i = 0; i < n; i++) {\n" +
//                "            if ( a < b ) {\n" +
//                "                a += b / 2;\n" +
//                "            }\n" +
//                "            for (int j = 0; j < n; j++) {\n" +
//                "                b++;\n" +
//                "                a += b;\n" +
//                "            }\n" +
//                "            for (int j = 1; j < n; j *= 2) {\n" +
//                "                b--;\n" +
//                "            }\n" +
//                "        }\n" +
//                "        System.out.println(a);\n" +
//                "    }\n" +
//                "}";
//        StringBuilder sb = new StringBuilder(ttt);


        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            sb.append(in.nextLine().trim());
        }

        String rawstr = sb.toString().replace(" ", "");
        rawstr = rawstr.replace("\n", "");

        Deque<Integer> forIfStack = new LinkedList<>(); // for 0 if 1 other 2
        int i = 0;
        int ans = 0;
        while (i < rawstr.length()) {
            if (rawstr.charAt(i) == '}') {
                int tmp = 0;
                for (Integer a : forIfStack) {
                    if (a == 0) {
                        tmp++;
                    }
                }
                ans = Math.max(ans, tmp);
                forIfStack.removeLast();
            } else if (rawstr.charAt(i) == '{') {
                int l = i;
                while (l >= 0 && rawstr.charAt(l) != '(') {
                    l--;
                }
                if (l < 0) {
                    forIfStack.addLast(2);
                    i++;
                    continue;
                }
                if (l >= 2 && rawstr.startsWith("for", l - 3)) {
                    forIfStack.addLast(0);
                } else if (l >= 1 && rawstr.startsWith("if", l - 2)) {
                    forIfStack.addLast(1);
                } else {
                    forIfStack.addLast(2);
                }
            }
            i++;
        }

        System.out.println(ans);
    }
}
