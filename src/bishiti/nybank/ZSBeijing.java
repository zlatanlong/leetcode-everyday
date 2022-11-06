package bishiti.nybank;

import java.util.Scanner;
public class ZSBeijing {

    public static void main(String[] str) {
//        int num = 51;
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String s = Integer.toBinaryString(num);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                System.out.print((int) Math.pow(2, i) + " ");
            }
        }
    }

    /** ATA-矩阵
     * @method findAllArray
     * @param rank 矩阵的阶
     * @return 满足条件的矩阵数量
     */
    public int findAllArray(int rank) {
        if(rank==1) return 1;
        int count = 0;
        int tmp = rank-1;
        while(tmp>0) {
            count += tmp;
            tmp--;
        }
        return (int) Math.pow(2,count);
    }

    /** ATA-学号信息
     * @method getStuID
     * @param Students_Data 学生信息
     * @return 学生的学号信息字符串
     */
    public String getStuID(String Students_Data) {
        String ans = "";
        int idx=0;

        while(idx<Students_Data.length()) {
            String tmp = "";
            while(idx<Students_Data.length() && Students_Data.charAt(idx)>='0' && Students_Data.charAt(idx)<='9') {
                tmp+=Students_Data.charAt(idx);
                idx++;
            }
            if(tmp.length()>0) {
                ans +=" ";
                ans +=tmp;
            }
            idx++;
        }
        return ans;
    }

    /** ATA-时钟
     * @method time_coincide
     * @param time 时刻
     * @return 时段(time~time+1)内时针与分针重合的时刻
     */
    public String time_coincide(int time) {
        int mtime = (time+12) % 12;
        int v1=30;
        int v2=360;
        if(mtime<=10) {
            int lucheng1 = mtime * 30;
            int lucheng2 = 0;
            double s = (lucheng1-lucheng2) * 60;
            long fenzhen = Math.round(s/(v2-v1));
            if(fenzhen<10) {
                return time +":0"+fenzhen;
            } else {
                return time +":"+fenzhen;
            }

        } else{
            return (time+1) +":00";
        }
    }
}
