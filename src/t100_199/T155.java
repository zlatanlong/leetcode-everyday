package t100_199;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/16 21:40
 * 只需要保留每一次的最小值
 */
public class T155 {

    private Deque<Integer> stack;
    private Deque<Integer>  minStack;

    public T155() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()||x<=minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int a = stack.pop();
        if (a == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
