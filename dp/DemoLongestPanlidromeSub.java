package dp;

import java.util.Scanner;

public class DemoLongestPanlidromeSub {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(solution(s));
        scanner.close();
    }

    // 最长回文子串，abcb
    public static String solution(String s) {
        int n = s.length();
        // 回文的含义，需要判断一个区间。所以需要两个下标
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 递推公式与保存状态。
        int largest = 1, start = 0;
        // 结果依赖于下一行而不是上一行，所以是倒序；
        for (int i = n - 1; i >= 0; i--) {
            // 结果依赖于左边而不是右边，所以是正序
            for (int j = i + 1; j < n; j++) {
                // j - i + 1 <= 3，确保能照顾到 bb 这种情况，如果没有这个条件，直接代入 dp[i + 1][j - 1]，得到 dp[i + 1][i]，结果恒为 false
                if (s.charAt(i) == s.charAt(j) && (j - i + 1 <= 3 || dp[i + 1][j - 1])) {
                    // 这个不能忘记，因为要确保后面的递推是正确的
                    dp[i][j] = true;
                    int cur_len = j - i + 1;
                    if (cur_len > largest) {
                        largest = cur_len;
                        start = i;
                    }
                }
            }
        }
        // substring 的含义是下标区间，所以 [start, largest) 是不对的，而应该是 [start, start + largest)
        return s.substring(start, start + largest);
    }
}
