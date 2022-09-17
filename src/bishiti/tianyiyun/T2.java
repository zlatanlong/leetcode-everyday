package bishiti.tianyiyun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Integer> ji = new ArrayList<>();
        List<Integer> ou = new ArrayList<>();
        String[] c = scanner.nextLine().split(",");
        for (int i = 0; i < n; i++) {
            Integer t = Integer.parseInt(c[i]);
            if (t % 2 ==0 ) {
                ou.add(t);
            } else {
                ji.add(t);
            }
        }
        ou.addAll(ji);
        for (int i = 0; i < ou.size()-1; i++) {
            System.out.print(ou.get(i) + ",");
        }
        System.out.println(ou.get(ou.size()-1));
    }
}
