package bishiti.bohaiyinhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/9/13 16:38
 */
public class T1 {

    public static void dfs(int po, int st, int huan) {
        int len = arr[st].size();
        flag[st] = true;
        for (int i = 0; i < len; i++) {
            int j = arr[st].get(i);
            if (huan == 3 && ((j == po) || !flag[j])) {
                count++;
                continue;
            }
            if (!flag[j]) {
                dfs(po, j, huan + 1);
                flag[j] = false;
            }
        }
    }

    static int count = 0;
    static ArrayList<Integer>[] arr = new ArrayList[10001];
    static boolean[] flag = new boolean[10001];


    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String c[] = bfr.readLine().split("\\s");
        int n = Integer.parseInt(c[0]);
        int m = Integer.parseInt(c[1]);
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            c = bfr.readLine().split("\\s");
            int u = Integer.parseInt(c[0]);
            int v = Integer.parseInt(c[1]);
            arr[u - 1].add(v - 1);
            arr[v - 1].add(u - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, i, 1);
            Arrays.fill(flag, false);
        }
        System.out.println(count);
    }
}
