package exams;

import java.util.ArrayDeque;
import java.util.Queue;

public class DemoMovingAverage {
    int size;
    int sum;
    Queue<Integer> deque = new ArrayDeque<>();
    DemoMovingAverage (int size) {
        this.size = size;
    }

    double next(int val) {
        if (deque.size() == size) {
            int num = deque.poll();
            sum = sum - num;
        }
        deque.offer(val);
        sum = sum + val;
        return (double) sum / deque.size();
    }

    public static void main(String[] args) {
        DemoMovingAverage demoMovingAverage = new DemoMovingAverage(3);
        System.out.println(demoMovingAverage.next(1));
        System.out.println(demoMovingAverage.next(10));
        System.out.println(demoMovingAverage.next(3));
        System.out.println(demoMovingAverage.next(5));

    }
}


