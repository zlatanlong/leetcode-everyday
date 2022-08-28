package bishiti.MicroSoft;

import java.util.HashMap;

public class Zuobiao {


    public static int solution(int[] A, int M) {
        // write your code in Java 8 (Java SE 8)
        int result = 0;
        int[] res = new int[M];
        for (int i = 0; i < A.length; i++) {
            int n = A[i] % M;
            if (n < 0) {
                n += M;
            }
            res[n]++;
            result = Math.max(result, res[n]);
        }

        return result;
    }

    public int solution2(int[] A, int M) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int tem = A[i] % M;
            if (tem < 0) {
                tem += M;
            }
            if (!hs.containsKey(tem)) {
                hs.put(tem, 1);
            } else {
                hs.put(tem, hs.get(tem) + 1);
            }
        }
        int res = 0;
        for (int key : hs.keySet()) {
            res = Math.max(res, hs.get(key));
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(-4%3);
    }
}
