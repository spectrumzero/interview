package hsqh;

import java.util.ArrayDeque;
import java.util.Deque;

public class DemoMinStack {
    public static void main(String[] args) {

    }
}

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    void push(int val) {
        stack.push(val);
        if (!minStack.isEmpty()) {
            if (val <= minStack.peek()) {
                minStack.push(val);
            }
        } else {
            minStack.push(val);
        }
    }

    void pop() {
        int num = stack.pop();
        if (!minStack.isEmpty() && minStack.peek() == num) {
            minStack.pop();
        }
    }

    int top() {
        return stack.peek();
    }

    int getMin() {
        return minStack.peek();
    }
}
