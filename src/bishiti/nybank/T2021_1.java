package bishiti.nybank;

public class T2021_1 {


    public void main1(String[] args) {
        int x = 4, y = 0;
        if (Math.pow(x, 2) == 16)
            y = x;
        if (Math.pow(x, 2) < 15)
            y = 1 / x;
        if (Math.pow(x, 2) > 15)
            y = (int) Math.pow(x, 2) + 1;
        System.out.println(y);
    }

    static int arr[] = new int[10];

    public int huiwenshu(int num) {
        String s = Integer.toBinaryString(num);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1)) return 0;
        }
        return 1;
    }

    public int sanshuzhihe(int num) {
        int count = 0;
        for (int i = 2; i <= num / 3 && isShushu(i); i++) {
            int first = i;
            int second = first;
            int third = num - first - first;
            while (second <= third) {
                if (!isShushu(second) || !isShushu(third)) {
                    second++;
                    third--;
                    continue;
                }
                count++;
                System.out.println(first + " " + second + " " + third);
                second++;
                third--;
            }
        }
        return count;
    }

    public boolean isShushu(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public String zuiduanxunhuan(String str) {
        String ans = str.substring(0, 2);
        for (int i = 2; i < str.length() / 2; i++) {
            if (str.substring(i).startsWith(ans)) {
                if (simpleValid(str, ans)) return ans;
            }

            ans += str.charAt(i);
        }

        return "no pattern";
    }

    public boolean simpleValid(String str, String pat) {
        int m = pat.length();
        int n = str.length();
        for (int i = 0; i < n; i += m) {
            String tmp = str.substring(i, Math.min(i + m, n));
            if (i + m <= n) {
                if (!tmp.equals(pat)) return false;
            } else {
                if (!pat.startsWith(tmp)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(arr[1]);

        T2021_1 t20211 = new T2021_1();
        System.out.println(t20211.sanshuzhihe(9));
//        System.out.println(t1.zuiduanxunhuan("12312313"));
    }

}
