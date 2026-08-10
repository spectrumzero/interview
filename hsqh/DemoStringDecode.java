package hsqh;

import java.util.ArrayDeque;
import java.util.Deque;

public class DemoStringDecode {
    public static void main(String[] args) {

    }

    public static String solution(String s) {
        Deque<Integer> digitStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        int num = 0;
        StringBuilder cur = new StringBuilder();
        for (Character c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 累积计数
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // 存储结果，后续匹配
                digitStack.push(num);
                strStack.push(cur);
                // 重置状态，正确进入 [ 里面
                cur = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                // 匹配，合并
                int times = digitStack.pop();
                StringBuilder prev = strStack.pop();
                for (int i = 0; i < times; i++) {
                    prev.append(cur);
                }
                cur = prev;
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
