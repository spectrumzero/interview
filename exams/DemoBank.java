package exams;

import java.util.Scanner;

public class DemoBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt(), n = scanner.nextInt();
        int[] prices = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        int res = solution(prices, values, amount);
        System.out.println(res);
    }

    public static int solution(int[] prices, int[] values, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < values.length; i++) {
            for (int j = amount; j >= 0; j--) {
                if (j >= prices[i]) {
                    dp[j] = Math.max(dp[j], dp[j - prices[i]] + values[i]);
                }
            }
        }
        return dp[amount];
    }
}
