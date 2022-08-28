package bishiti.wanmei;

import java.util.*;

/**
 * @author zlatanlong
 * @date 2022/8/27 13:15
 */
public class T1 {

    public int lastGarbageSize(int[] garbages) {
        // 在这⾥写代码
        int len = garbages.length;
        Arrays.sort(garbages);
        List<Integer> tmp = new ArrayList<>();
        for (int garbage : garbages) {
            tmp.add(garbage);
        }
        while (true) {
            List<Integer> newtmp = new ArrayList<>();
//            System.out.println(tmp.size());
            for (int i = 0; i <= tmp.size() - 1 - i; i++) {
                int t = 0;
                if (i != tmp.size() - 1 - i)
                    t = Math.abs(tmp.get(i) - tmp.get(tmp.size() - 1 - i));
                else
                    t = tmp.get(i);
                newtmp.add(t);
            }

            if (tmp.size() == 1) return tmp.get(0);
            if (tmp.size() == 0) return 0;
            Collections.sort(newtmp);
            tmp = newtmp;
        }
    }

    public int lastGarbageSize2(int[] garbages) {
        // 在这⾥写代码
        PriorityQueue<Integer> q = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int garbage : garbages) {
            q.add(garbage);
        }
        while (q.size() > 1) {
            int g1 = q.poll();
            int g2 = q.poll();
            if (g1 == g2) {
                continue;
            } else {
                q.add(Math.abs(g1 - g2));
            }
        }
        return q.isEmpty() ? 0 : q.peek();
    }

    public static void main(String[] args) {
//        System.out.println(new T1().lastGarbageSize(new int[]{30, 45, 12, 23, 8}));
//        System.out.println(new T1().lastGarbageSize(new int[]{2,1,9,8,4,2,3,5}));
        System.out.println(new T1().lastGarbageSize(new int[]{2, 1, 9, 8, 4, 2, 5}));
    }
}
