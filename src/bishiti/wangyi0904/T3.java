package bishiti.wangyi0904;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/9/4 15:12
 */
public class T3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(n, (e1, e2) -> e2 - e1);
        for (int i = 0; i < n; i++) {
            queue.offer(scanner.nextInt());
        }
        scanner.nextLine();
        if (queue.size() == 1) {
            System.out.println(queue.peek() - k * x);
            return;
        }
        while (k > 0) {
            Integer da1 = queue.poll();
            Integer da2 = queue.peek();
            int beishu = 1 + (da1 - da2) / x;
            if (beishu <= k) {
                queue.offer(da1 - beishu * x);
                k -= beishu;
            } else {
                System.out.println(queue.peek() - k * x);
                return;
            }
        }
        System.out.println(queue.peek());
    }
}
