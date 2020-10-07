package jzoffer.jz15;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/6 22:15
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0) {
            if ((n&1)==1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(-3));
    }
}
