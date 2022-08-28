package mianshi;

import java.util.ArrayList;

public class MS62 {
    /**
     * 链表解法 时间复杂度O(n^2)
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        MS62 solution = new MS62();
        System.out.println(solution.lastRemaining(7,3));
    }

}

// 约瑟夫环
//class Solution {
//    public int lastRemaining(int n, int m) {
//        int ans = 0;
//        // 最后一轮剩下2个人，所以从2开始反推
//        for (int i = 2; i <= n; i++) {
//            ans = (ans + m) % i;
//        }
//        return ans;
//    }
//}
