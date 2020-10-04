package jzoffer.jz10_1;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 17:08
 */
public class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        long lastLast = 0;
        long last = 1;
        long count = 0;
        for (int i = 2; i <= n; i++) {
            count = (last + lastLast)% 1000000007L;
            lastLast = last;
            last = count;
        }
        return (int) (count % 1000000007L);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(93));
    }
}
