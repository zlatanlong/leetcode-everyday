package bishiti.meituan827;

import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/27 17:22
 */
public class T4 {


    public int zuiduanshijian(int b, int[] parr, int[] tarr) {
//        if (parr[0] > b) return -1;
//        ArrayList<Integer> list = new ArrayList<>();
//        int hdl =
//        for (int i = 0; i < tarr.length; i++) {
//            ans += tarr[i];
//        }

        return 0;
//        return list.stream().max((e1, e2) -> e1 - e2).get();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split("\\s");
        String[] s2 = scanner.nextLine().split("\\s");
        String[] s3 = scanner.nextLine().split("\\s");
        int n = Integer.parseInt(s1[0]);
        int b = Integer.parseInt(s1[1]); //电量
        int[] parr = new int[n];
        int[] tarr = new int[n];
        for (int i = 0; i < n; i++) {
            parr[i] = Integer.parseInt(s2[i]);
            tarr[i] = Integer.parseInt(s3[i]);
        }
        System.out.println(new T4().zuiduanshijian(b, parr, tarr));

    }
}
