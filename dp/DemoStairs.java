package dp;

import java.util.Scanner;

public class DemoStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(up(scanner.nextInt()));
        scanner.close();
    }

    public static int up(int steps) {
        if (steps <= 2) {
            return steps;
        }

        int[] dp = new int[steps + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= steps; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[steps];

    }
}
