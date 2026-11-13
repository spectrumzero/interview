package dp;

import java.util.Scanner;

public class DemoEditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine().trim();
        String word2 = scanner.nextLine().trim();
        int res = modification(word1, word2);
        System.out.println(res);
        scanner.close();
    }

    public static int modification(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 相等，等价于之前的结果
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static int solutionTwo(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }
        for (int i = 1; i <= m; i++) {
            int left_up = dp[0];
            // 先初始化左上角，再更新 dp[0] 的值
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                // 提前保存当前状态
                int tmp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = left_up;
                } else {
                    dp[j] = 1 + Math.min(Math.min(dp[j], dp[j - 1]), left_up);
                }
                // 赋值
                left_up = tmp;
            }
        }
        return dp[n];

    }
}
