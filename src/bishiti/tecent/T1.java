package bishiti.tecent;

import java.util.LinkedList;
import java.util.Scanner;

public class T1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.addLast(scanner.nextInt());
        }
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                if (list.getFirst() > list.getLast()) System.out.print(list.removeFirst() + " ");
                else System.out.print(list.removeLast() + " ");
            } else {
                if (list.getFirst() > list.getLast()) System.out.print(list.removeLast() + " ");
                else System.out.print(list.removeFirst() + " ");
            }
        }
        System.out.println(list.get(0));
    }

}
