package JavaDevelopmentClassTest;

import java.util.HashMap;
import java.util.Map;

public class T332 {
    private Map<Integer,Integer> memo;

    public T332() {
        this.memo = new HashMap<>();
    }

    public int coinChange(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = 10000;
        for (int i = 0; i < coins.length; i++) {
            int subProblem = coinChange(coins, amount - coins[i]);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        res  = res == 10000 ? -1 : res;
        memo.put(amount, res);
        return res;
    }

    public static void main(String[] args) {
        T332 t332 = new T332();
        int[] arr = {1, 2, 5};
        long startTime = System.currentTimeMillis();
        System.out.println(t332.coinChange(arr, 100));
        long endTime= System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间

    }

}
