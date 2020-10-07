package jzoffer.jz65;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/7 16:13
 */
public class Solution {

    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
