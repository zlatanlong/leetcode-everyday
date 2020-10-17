package jzoffer.jz31;

import java.util.LinkedList;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/11 20:00
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] == popped[index]) {
                index++;
                while (list.peek()!=null&&list.peek()==popped[index]) {
                    index++;
                    list.pop();
                }
                continue;
            }
            list.push(pushed[i]);
        }
        return list.isEmpty();
    }
}
