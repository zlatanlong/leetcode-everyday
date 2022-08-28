package t001_099;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/14 21:29
 */
public class T20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> list = new LinkedList<>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                list.push(c);
            } else {
                if (list.isEmpty()) {
                    return false;
                }
                char a = list.pop();
                if (c == ')' && a != '(' || c == ']' && a != '[' || c == '}' && a != '{') {
                    return false;
                }
            }
        }
        return list.isEmpty();
    }
}
