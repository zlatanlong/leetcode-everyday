package jzoffer.jz09;

import java.util.LinkedList;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 13:40
 */
public class CQueue {
    LinkedList<Integer> A, B;

    public CQueue() {
        this.A = new LinkedList<>();
        this.B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.push(value);
    }

    public int deleteHead() {
        if (A.isEmpty() && B.isEmpty()) {
            return -1;
        }
        if (!B.isEmpty()) {
            return B.pop();
        }
        while (!A.isEmpty()) {
            B.push(A.pop());
        }
        return B.pop();
    }
}
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */