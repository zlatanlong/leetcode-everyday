package bishiti.meituan827.tuanzi;

import java.util.LinkedList;
import java.util.Scanner;

public class T4 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int all = sc.nextInt();
        int[] parr = new int[n];
        for (int i = 0; i < n; i++) {
            parr[i] = sc.nextInt();
        }
        int[] tarr = new int[n];
        for (int i = 0; i < n; i++) {
            tarr[i] = sc.nextInt();

        }
        if (parr[0] > all) {
            System.out.println(-1);
            return;
        }
        int maxTime = tarr[0] * n;
        // 找所有方案
        int left = all - parr[0];
        LinkedList<LinkedList<Integer>> allFunc = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            LinkedList<Integer> tem = new LinkedList<>();
            int leftTem = left;
            for (int j = i; j < n; j++) {
                if (parr[j] <= leftTem) {
                    leftTem -= parr[j];
                } else {
                    break;
                }

                tem.add(j);
            }
            if (tem.size() > 0) {
                allFunc.add(tem);
            }
        }
        for (LinkedList<Integer> inner : allFunc) {
            int firstIndex = inner.get(0);
            int temTime = tarr[0] * firstIndex;
            for (int i = 1; i < inner.size() - 1; i++) {
                int start = inner.get(i);
                int end = inner.get(i + 1);
                temTime = Math.max(temTime, tarr[start] * (end - start));
            }
            temTime = Math.max(temTime, tarr[inner.get(inner.size() - 1)] * (n - inner.get(inner.size() - 1)));
            maxTime = Math.min(maxTime, temTime);
        }
        System.out.println(maxTime);
    }

}
