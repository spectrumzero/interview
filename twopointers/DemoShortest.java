package twopointers;

import java.util.Locale;
import java.util.Scanner;

public class DemoShortest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String t = scanner.nextLine().trim();
        String res = shortest(s, t);
        if (res.isEmpty()) {
            System.out.println();
        } else {
            System.out.println(res);
        }
        scanner.close();
    }

    public static String shortest(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] count = new int[128];
        int diff = t.length();
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        // 一个用来返回结果，一个用来推进优化
        int start = 0, left = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]--;
            // 是大于等于 0，而不是单独等于 0。因为 diff 是算了所有的 t 字符
            if (count[s.charAt(i)] >= 0) {
                diff--;
            }

            // 优化
            while (diff == 0) {
                // 先统计结果
                int curSize = i - left + 1;
                if (curSize < res) {
                    res = curSize;
                    start = left;
                }
                // 抹除
                count[s.charAt(left)]++;
                // 破坏平衡
                if (count[s.charAt(left)] > 0) {
                    diff++;
                }
                // 更新移动抹除指针
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);

    }
}
