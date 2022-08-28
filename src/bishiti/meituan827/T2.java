package bishiti.meituan827;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/27 16:21
 */
class T2 {

    public String opt(int n, int m, int[] optNums) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < m; i++) {
            deque.addFirst(optNums[i]);
        }
        StringBuilder ans = new StringBuilder();
        boolean[] flag = new boolean[n];
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            Integer integer = deque.removeFirst();
            if (flag[integer - 1]) continue;
            ans.append(integer);
            flag[integer - 1] = true;
            if (i != deque.size())
                ans.append(" ");
        }
        return ans.toString();
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split("\\s");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        String[] s2 = scanner.nextLine().split("\\s");
        int[] optNums = new int[m];
        for (int i = 0; i < optNums.length; i++) {
            optNums[i] = Integer.parseInt(s2[i]);
        }
        System.out.println(new T2().opt(n, m, optNums));
//        System.out.println(new T1().solution(7, 3, "abcaacc", "a*c"));
    }
}
