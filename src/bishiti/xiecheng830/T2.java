package bishiti.xiecheng830;

import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/30 18:57
 */
public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = Integer.parseInt(in.nextLine());
        // 注意 hasNext 和 hasNextLine 的区别
        int[][] quests = new int[q][3];
        for (int i = 0; i < q; i++) {
            String[] split = in.nextLine().split("\\s");
            for (int j = 0; j < 3; j++) {
                quests[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < q; i++) {
            int[] curq = quests[i];
            int min = Math.min(curq[0], Math.min(curq[1], curq[2]));
            int curans = min * 2 + Math.max(0, curq[1] - min - 1);
            System.out.println(curans);
        }
    }
}
