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

    public static int minCoinsOneDemension(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 无效解标识，不要用 Integer.MAX_VALUE，因为后面会整形溢出的，有一个 + 1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin: coins) {
            for (int j = 1; j <= amount; j++) {
                if (coin <= j) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    public static int minCoins(int[] nums, int amount) {
        int n = nums.length, m = amount;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = amount + 1;
        }
        for (int i = 1; i <= n; i++) {
            int coin = nums[i - 1];
            for (int j = 1; j <= amount; j++) {
                // 不取
                dp[i][j] = dp[i - 1][j];
                if (coin <= j) {
                    // 钱币
                    // 取或不取
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin] + 1);
                }
            }
        }
        return dp[n][m] == amount + 1 ? -1 : dp[n][m];
    }

}
