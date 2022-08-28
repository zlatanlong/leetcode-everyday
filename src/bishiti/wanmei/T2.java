package bishiti.wanmei;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zlatanlong
 * @date 2022/8/27 15:10
 */
public class T2 {


    public int[][] mergeCard(int[][] cards) {
        // 在这⾥写代码
        Arrays.sort(cards, (c1, c2) -> c1[0] - c2[0]);
        int len = cards.length;
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{cards[0][0], cards[0][1]});
        for (int i = 1; i < len; i++) {
            int[] c = list.get(list.size() - 1);
            if (cards[i][0] > c[1]) list.add(new int[]{cards[i][0], cards[i][1]});
            else c[1] = Math.max(c[1], cards[i][1]);
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }

    public static void main(String[] args) {
        new T2().mergeCard(new int[][]{{1, 5}, {2, 7}, {9, 11}, {20, 30}});
    }
}
