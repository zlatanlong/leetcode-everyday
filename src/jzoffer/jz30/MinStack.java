package jzoffer.jz30;

import java.util.LinkedList;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 15:19
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    LinkedList<Integer> linkedList;
    LinkedList<Integer> deque;

    public MinStack() {
        linkedList = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public void push(int x) {
        linkedList.push(x);
        // deque记录每一步的最小值，如果不是最小，不需要记录
        if (deque.isEmpty() || deque.peekLast() >= x) {
            deque.addLast(x);
        }
    }

    public void pop() {
        int p = linkedList.pop();
        // 判断当前最小值是否为出栈的值
        if (deque.peekLast() != null && deque.peekLast().equals(p)) {
            deque.removeLast();
        }
    }

    public int top() {
        return linkedList.peek() == null ? -1 : linkedList.peek();
    }

    public int min() {
        return deque.peekLast() == null ? -1 : deque.peekLast();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
