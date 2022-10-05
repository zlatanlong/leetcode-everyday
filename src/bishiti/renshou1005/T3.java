package bishiti.renshou1005;

import java.util.Map;
import java.util.Scanner;

public class T3 {
    static int max;

    public static void dfs(int[] cards, int[] golds, int start, int cur) {
        cur += golds[start];

        if (start == golds.length - 1) {
            max = Math.max(max, cur);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cards[i] == 0 || start + i + 1 >= golds.length) {
                continue;
            }
            cards[i]--;
            dfs(cards, golds, start + i + 1, cur);
            cards[i]++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] golds = new int[n];
        int[] cards = new int[4];
        for (int i = 0; i < n; i++) {
            golds[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            cards[i] = scanner.nextInt();
        }
        max = 0;
        dfs(cards, golds, 0, 0);
        System.out.println(max);
    }
}
