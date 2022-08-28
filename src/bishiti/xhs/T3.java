package bishiti.xhs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class T3 {

    public void test() {
        int n = 10;
        int[][] graph = new int[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            inner:
            for (int j = i+1; j < n; j++) {
                count++;
                if (graph[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        graph[i][k] = 0;
                        graph[j][k] = 0;
                    }
                    break inner;
                }
            }
        }
    }

    public void test2() {
        int n = 10;
        int[][] graph = new int[n][n];
        int count = 0;
        while (true) {

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        int n = Integer.parseInt(s1);
        String s2 = scanner.nextLine();
        String[] ss2 = s2.split("\\s");
        int[][] guanxi = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            int ii = Integer.parseInt(ss2[i]);
            guanxi[i][0] = i + 2;
            guanxi[i][1] = ii;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            map.put(guanxi[i][0], map.getOrDefault(guanxi[i][0], 0) + 1);
            map.put(guanxi[i][1], map.getOrDefault(guanxi[i][1], 0) + 1);
        }
        int[][] friends = new int[n][2];
        int index = 0;

        for (Integer key : map.keySet()) {
            friends[index][0] = key;
            friends[index][1] = map.get(key);
            index++;
        }
        Arrays.sort(friends, (e1, e2) -> e1[1] - e2[1]);
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(friends[i][0])) {
                continue;
            }
            boolean flag = false;
            for (int j = 0; j < n - 1; j++) {
                if (guanxi[j][0] == friends[i][0]) {
                    if (set.contains(guanxi[j][1])) {
                        ans++;
                        flag = true;
                        set.add(guanxi[j][1]);
                        set.add(friends[i][0]);
                    }
                    if (flag) break;
                }
                if (guanxi[j][1] == friends[i][0]) {
                    if (set.contains(guanxi[j][0])) {
                        ans++;
                        flag = true;
                        set.add(guanxi[j][0]);
                        set.add(friends[i][0]);
                    }
                    if (flag) break;
                }
            }
        }


        System.out.println(ans);
    }
}
