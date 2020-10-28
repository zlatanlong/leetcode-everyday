package JavaDevelopmentClassTest;

/**
 * 完全背包问题
 */
public class T1449 {

  public String largestNumber(int[] cost, int target) {
    int len = cost.length;
    // 各留一个0,0的
    String dp[][] = new String[len + 1][target + 1];

    for (int i = 0; i <= len; i++) {
      for (int j = 0; j <= target; j++) {

        // 完全背包，要求装满
        if (i == 0 || j == 0) {
          dp[i][j] = "";
          continue;
        }

        String old = dp[i - 1][j];
        String s = "";

        if (j >= cost[i - 1]) {
          // 有空间装
          int newj = j - cost[i - 1];
          // newj==0 时刚好可以装
          if (dp[i][newj].equals("") && newj > 0) // 装满的限定
            s = "";
          else
            s = String.valueOf(i) + dp[i][newj];
        }
        // 比较，是否装包
        if (s.length() == old.length())
          dp[i][j] = s.compareTo(old) > 0 ? s : old;
        else
          dp[i][j] = s.length() > old.length() ? s : old;
      }
    }
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (dp[i][j].equals(""))
          System.out.print("0" + "\t");
        else
          System.out.print(dp[i][j] + "\t");
      }
      System.out.println();
    }
    return dp[len][target].equals("") ? "0" : dp[len][target];
  }

  public static void main(String[] args) {
    T1449 t1449 = new T1449();
    int[] cost = { 4,3,2,5,6,7,2,5,5 };
    int target = 9;
    // System.out.println(t1449.largestNumber(cost, target));
    t1449.largestNumber(cost, target);
    System.out.println("-----------------end-------------------");
  }
}
