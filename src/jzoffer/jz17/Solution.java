package jzoffer.jz17;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 18:12
 */
public class Solution {
    public int[] printNumbers(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = count * 10 + 9;
        }
        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }

    public int[] printNumbers2(int n) {
        return null;
    }
}


