package bishiti.bohaiyinhang;

public class Zhaoshang {
    public static void main(String[] args) {
        int[][] data = new int[][]{{8, 11}, {9, 10}, {10, 11}};
        int[] count = new int[25];
        for (int[] darr : data) {
            for (int i = darr[0]; i <= darr[1]; i++) {
                count[i]++;
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i <= 24; i++) {
            if (count[i] > max) {
                max = count[i];
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
    }
}
