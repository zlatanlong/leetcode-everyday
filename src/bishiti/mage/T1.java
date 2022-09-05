package bishiti.mage;

public class T1 {


    public static int xiaohong(String str) {
        if (str.length() == 1) {
            return 0;
        }
        if (str.length() == 2) {
            return 0;
        }
        int 操作次数 = 0;
        int oriquan = 0;
        int 实际权值减少 = 0;
        for (int i = 0; i < str.length(); i++) {
            // 三个不连续肯定能修复一个
            if (i != 0 && i != str.length() - 1
                    && 操作次数 < 2
                    && str.charAt(i - 1) != str.charAt(i) &&
                    str.charAt(i) != str.charAt(i + 1)) {
                操作次数++;
                if (str.charAt(i - 1) == str.charAt(i + 1)) {
                    实际权值减少 += 2;
                } else {
                    实际权值减少++;
                }
            }
            // 正常统计权值
            if (i != 0 && str.charAt(i - 1) != str.charAt(i)) {
                oriquan++;
            }
        }
        if (操作次数 < 2 && str.charAt(0) != str.charAt(1)
                && str.charAt(1) == str.charAt(2)) {
            操作次数++;
            实际权值减少++;
        }
        if (操作次数 < 2 && str.charAt(str.length() - 1) != str.charAt(str.length() - 2)
                && str.charAt(str.length() - 2) == str.charAt(str.length() - 3)) {
            操作次数++;
            实际权值减少++;
        }

        return Math.max(0, oriquan - 实际权值减少);
    }

    public static void main(String[] args) {

    }
}
