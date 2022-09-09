package bishiti.jingdong;

import java.util.*;

public class T2 {
    static class IndexAndValue {
        int index;
        int val;

        public IndexAndValue() {
        }

        public IndexAndValue(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public static double MODAL = 10e9 + 7;

    public static int jiecheng(int big, int small) {
        long sum1 = 1;
        long sum2 = 1;
        for (int i = 1; i <= big; i++) {
            sum1 *= i;
        }
        if (small < big / 2) {
            for (int i = 1; i <= small; i++) {
                sum2 *= i;
            }
        } else {
            for (int i = 1; i <= big - small; i++) {
                sum2 *= i;
            }
        }
        return (int) (sum1 / sum2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        List<Integer> ji = new ArrayList<>(n);
        List<Integer> ou = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            nums[i] = t;
            if ((t & 1) == 0) {
                ou.add(t);
            } else {
                ji.add(t);
            }
        }
        in.nextLine();
        int ans = 0;
        ji.sort(Comparator.comparingInt(e -> e));
        // 从两个的组合开始
        int tmp;
        for (int j = 2; j <= ji.size(); j++) {
            tmp = 0;
            while (tmp + j <= ji.size()) {
                // 先找到第一个不重复的
                int rpcnt = 1;
                while (tmp + 1 < ji.size() - 1 && ji.get(tmp) == ji.get(tmp + 1)) {
                    tmp++;
                    rpcnt++;
                }
                long i;
                if (ji.size() - 1 - tmp < j - 1) {
                    if (rpcnt != 1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                    i = rpcnt * jiecheng(ji.size() - 1 - tmp, j - 1);
                }
                ans += i % MODAL;
                ans %= MODAL;
                if (rpcnt >= j) ans++;
                tmp++;
            }
        }

        ou.sort(Comparator.comparingInt(e -> e));
        // 从两个的组合开始
        for (int j = 2; j <= ou.size(); j++) {
            tmp = 0;
            while (tmp + j <= ou.size()) {
                // 先找到第一个不重复的
                int rpcnt = 1;
                while (tmp + 1 < ou.size() - 1 && ou.get(tmp) == ou.get(tmp + 1)) {
                    tmp++;
                    rpcnt++;
                }
                long i;
                if (ou.size() - 1 - tmp < j - 1) {
                    if (rpcnt != 1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                    i = rpcnt * jiecheng(ou.size() - 1 - tmp, j - 1);
                }
                ans += i % MODAL;
                ans %= MODAL;
                if (rpcnt >= j) ans++;
                tmp++;
            }
        }
        System.out.println(ans);
    }
}
