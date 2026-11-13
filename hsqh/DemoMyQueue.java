package hsqh;


import java.util.ArrayDeque;
import java.util.Deque;

class myQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    myQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    void push(int x) {
        // 先 inStack
        inStack.push(x);
    }

    int pop() {
        if (outStack.isEmpty()) {
            // 必须要是整体的翻转才可以，需要把 inStack 中的元素整体倒出，不能只倒一个
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    int peek() {
        if (outStack.isEmpty()) {
            // 同理的
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    boolean isEmpty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

}

public class DemoMyQueue {
    public static void main(String[] args) {

    }


}
