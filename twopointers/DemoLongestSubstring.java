package twopointers;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DemoLongestSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 防抛异常，scanner 发现没有行，再调用 nextLine 会报错的
        if (!scanner.hasNextLine()) {
            System.out.println(0);
            return;
        }
        String s = scanner.nextLine().trim();
        int res = longest(s);
        System.out.println(res);
        scanner.close();
    }

    // 最长无重复字符子串
    public static int longest(String s) {
        int res = 0;
        if (s.length() == 0) {
            return res;
        }
        Set<Character> set = new HashSet<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(s.charAt(i));
            }
            res = Math.max(set.size(), res);
        }
        return res;
    }
}
