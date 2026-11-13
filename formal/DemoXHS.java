package formal;

import java.util.Scanner;

public class DemoXHS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] numsX = new int[n];
        for (int i = 0; i < n; i++) {
            numsX[i] = scanner.nextInt();
        }
        int[] numsY = new int[m];
        for (int j = 0; j < m; j++) {
            numsY[j] = scanner.nextInt();
        }
        int res = solution(numsX, numsY);
        System.out.println(res);
    }

    // 特征序列优化
    // 让 numsX 和 numsY 序列变得完全一致。X 和 Y 的差别体现在数量，也提现在排列上
    // 你可以任意选择一组，将 a 修正为 b，花费 |a - b|，也可以直接删除 a，花费 a。
    // 输出最小损耗成本，确保 2 个序列完全一致
    public static int solution(int[] numsX, int[] numsY) {
        int m = numsX.length;
        int n = numsY.length;
        int[][] dp = new int[m + 1][n + 1];
        // 初始化
        for (int i = 1; i <= m; i++) {
            // 你的成本是累积的
            dp[i][0] = dp[i - 1][0] + Math.abs(numsX[i - 1]);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + Math.abs(numsY[j - 1]);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 删除 a，或删除 b，或修改 a 为 b
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + Math.abs(numsX[i - 1]), dp[i][j - 1] + Math.abs(numsY[j - 1])), dp[i - 1][j - 1] + Math.abs((numsX[i - 1] - numsY[j - 1])));
            }
        }
        return dp[m][n];
    }
}
