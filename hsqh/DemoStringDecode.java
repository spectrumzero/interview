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
                // 提醒，编码规则为 k[encoded_string]，不会出现 3a[cc] 这种情况，可以是 a3[cc]，所以是直接在 prev 后面 append N times
                StringBuilder prev = strStack.pop();
                int times = digitStack.pop();
                for (int i = 0; i < times; i++) {
                    prev.append(cur);
                }
                // 在这个算法中，cur 永远代表当前层级正在构建的字符串。
                cur = prev;
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
