package bishiti.xiaomi0920;

public class T2 {

    public int minimizedMaximum(int n, int[] quantities) {
        int maxQ = 0;
        for (int q : quantities) {
            maxQ = Math.max(maxQ, q);
        }

        int ans = 1;
        for (int i = 1; i <= maxQ; i++) {
            int tmp = 0;
            for (int q : quantities) {
                tmp += (q + (i - 1)) / i;
            }
            if (tmp < n) {
                return ans;
            }
            ans = i;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T2().minimizedMaximum(6, new int[]{11, 6}));
    }

}
