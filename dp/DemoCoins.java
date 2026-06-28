package dp;

import java.util.Arrays;
import java.util.Scanner;

public class DemoCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().trim().split("\\s+");
        int length = inputs.length;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }
        int amount = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(minCoinsOneDemension(nums, amount));
        scanner.close();
    }

    public static int minCoins(int[] nums, int amount) {
        int n = nums.length, m = amount;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            int coin = nums[i - 1];
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (coin <= j) {
                    // 钱币
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin] + 1);
                }
            }
        }
        return dp[n][m] == Integer.MAX_VALUE ? -1 : dp[n][m];
    }

    public static int minCoinsOneDemension(int[] nums, int amount) {
        int[] dp = new int[amount + 1];
        // 考虑无效解
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            int coin = nums[i - 1];
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }
}
