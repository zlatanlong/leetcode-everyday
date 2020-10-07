package jzoffer.jz58_2;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 19:53
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
