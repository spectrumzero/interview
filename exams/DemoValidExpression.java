package exams;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class DemoValidExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int res = getLength(s);
        System.out.println(res);
        scanner.close();
    }

    public static int getLength(String s) {
        if (s.isEmpty()) return 0;
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >=0; i--) {
            stack.push(chars[i]);
        }
        if (stack.peek() == '+') return 0;
        char c = stack.pop();
        if (c == '-') {
            if (!stack.isEmpty() && (stack.peek() == '-' || stack.peek() == '+')) {
                return 0;
            }
        }
        if (stack.isEmpty()) return 0;
        int res = 1;
        while (!stack.isEmpty()) {
            int flag = 0;
            while (!stack.isEmpty() && stack.peek() != '-' && stack.peek() != '+') {
                char digit = stack.pop();
                res++;
                if (flag == 0 && digit == '0') {
                    flag = 1;
                    if (!stack.isEmpty() && (stack.peek() != '+' || stack.peek() != '-')) {
                        return res;
                    }

                }
            }
            if (stack.isEmpty()) {
                return res;
            }
            char op = stack.pop();
            if (stack.isEmpty()) {
                return res;
            }
            if (stack.peek() == '-' || stack.peek() == '+') {
                return res;
            }
            // 后面依旧是数字了
            res++;
        }
        return res;

    }
}
