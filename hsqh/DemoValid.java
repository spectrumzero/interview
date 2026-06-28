package hsqh;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DemoValid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        boolean res = isValid(s);
        if (res == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 只 pop 一次。哪怕是检查，如果是 pop，也是会 pop 的。
                if (stack.isEmpty()) return false;
                if (stack.peek() == '(' && c != ')') return false;
                if (stack.peek() == '[' && c != ']') return false;
                if (stack.peek() == '{' && c != '}') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
