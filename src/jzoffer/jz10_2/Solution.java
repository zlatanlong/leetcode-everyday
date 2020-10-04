package jzoffer.jz10_2;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 20:05
 */
public class Solution {
    public int numWays(int n) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int count = (a+b)%1000000007;
            a = b;
            b = count;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(7));
    }
}
