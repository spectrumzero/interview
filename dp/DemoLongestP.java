package dp;

import java.util.Scanner;

// 最长有效括号
public class DemoLongestP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(longestValidP(s));
        scanner.close();
    }

    public static int longestValidP(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int res = 0;
        // 可以简化一种情况，从 i = 1 开始
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                // 两种情况
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    // 索引
                    if (i - 2 >= 0) {
                        dp[i] = 2 + dp[i - 2];
                    }
                }

                if (s.charAt(i - 1) == ')') {
                    // 已经兼顾到 dp[i - 1] 本身不合法，为 0 的情况了，因为如果为 0，与下面的 s.charAt() 是直接矛盾，为 false，不会走递推逻辑了
                    // 考虑 match 即可
                    int match = i - dp[i - 1] - 1;
                    if (match >= 0 && s.charAt(match) == '(') {
                        dp[i] = 2 + dp[i - 1];
                        // 索引
                        if (match - 1 >= 0) {
                            dp[i] += dp[match - 1];
                        }
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;

    }
}
