package dp;

import java.util.Scanner;

public class DemoLongestCommon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine().trim();
        String text2 = scanner.nextLine().trim();
        int res = longestCommon(text1, text2);
        System.out.println(res);
        scanner.close();
    }

    // 最长公共子序列
    public static int longestCommon(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // dp 是既定公共子序列的长度，而非所需编辑次数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // 只有两个选择，要么删除一个，要么删除另外一个，题目要求
                    // 无效，那么就从两边中选择一个去掉，从两个可能有效的，选择最长的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    // 空间优化参考
    public static int longestCommonPerformance(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int pre = dp[0];
            for (int j = 1; j <= m; j++) {
                int tmp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = tmp;
            }
        }
        return dp[m];
    }
}
