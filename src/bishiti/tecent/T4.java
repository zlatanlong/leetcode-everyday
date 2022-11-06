package bishiti.tecent;

import java.util.LinkedList;
import java.util.Scanner;

public class T4 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            count += nums[i];
        }

    }
}
