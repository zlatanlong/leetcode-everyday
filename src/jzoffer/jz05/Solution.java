package jzoffer.jz05;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 17:01
 */
public class Solution {
    public String replaceSpace(String s) {
        return s.replaceAll("\\s","%20");
    }

    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace("We are happy"));
    }
}
