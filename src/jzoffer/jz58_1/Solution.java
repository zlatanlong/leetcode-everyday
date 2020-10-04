package jzoffer.jz58_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 21:01
 */
public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 32) {
                if (i >= 1 && chars[i - 1] != 32) {
                    list.add(String.valueOf(Arrays.copyOfRange(chars, start, i)));
                }
                start = i + 1;
                continue;
            }
            if (i == chars.length - 1) {
                if (chars[i] == 32) {
                    break;
                }
                list.add(String.valueOf(Arrays.copyOfRange(chars, start, i + 1)));
            }
        }
        Collections.reverse(list);
        StringBuilder stringBuilder = new StringBuilder();
        list.stream().limit(list.size()-1).forEach(str -> stringBuilder.append(str).append(" "));
        stringBuilder.append(list.get(list.size() - 1));
        return String.valueOf(stringBuilder);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords(
                "  hello world!  "));
    }
}
