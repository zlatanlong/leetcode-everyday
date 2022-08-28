package meituan827;

import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/27 16:44
 */
public class T3 {

    int count = 0;
    boolean[] visited;

    public T3(int smallCount) {
        count = 0;
        visited = new boolean[smallCount];
    }

    public int caijian(String bigS, String[] smallSArr) {
        dfs(bigS, smallSArr, new StringBuilder());

        return count;
    }

    public void dfs(String bigS, String[] smallSArr, StringBuilder cur) {
        if (cur.toString().equals(bigS)) {
            count++;
            return;
        }
        if (cur.length()>0 && !bigS.startsWith(cur.toString())) return;
        for (int i = 0; i < smallSArr.length; i++) {
            if (visited[i]) continue;

            String small = smallSArr[i];
            if (cur.length() + small.length() > bigS.length()) continue;

            visited[i] = true;
            cur.append(smallSArr[i]);

            dfs(bigS, smallSArr, cur);

            visited[i] = false;
            if (cur.length() - small.length() > 0)
                cur.delete(cur.length() - small.length() - 1, cur.length() - 1);
            else
                cur = new StringBuilder();
        }

    }


    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        String[] s1 = scanner.nextLine().split("\\s");
//        String bigS = scanner.nextLine();
//        String[] s3 = scanner.nextLine().split("\\s");
////        int bigSize = Integer.parseInt(s1[0]);
//        int smallCount = Integer.parseInt(s1[1]);
//
////        int[] smallSizeArr = new int[smallCount];
////        for (int i = 0; i < smallSizeArr.length; i++) {
////            smallSizeArr[i] = Integer.parseInt(s3[i]);
////        }
//        String[] smallSArr = new String[smallCount];
//        for (int i = 0; i < smallCount; i++) {
//            smallSArr[i] = scanner.nextLine();
//        }
//        System.out.println(new T3(smallCount).caijian(bigS, smallSArr));
        System.out.println(new T3(2).caijian("aaaaaa", new String[]{"aaaa", "aa"}));

    }
}
