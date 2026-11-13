package exams;

import java.util.Scanner;

// 携程
public class DemoXC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextLong();
        }
        long[] dp = new long[n + 1];
        dp[1] = nums[1];
        // 解一
        long sum = dp[1];
        // 解二
        int len = 1;
        // 解三
        int bestLeft = 1;
        int currentLeft = 1;
        for (int i = 2; i <= n; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
                currentLeft = i;
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            int currentLen = i - currentLeft + 1;

            if (dp[i] > sum || (dp[i] == sum && currentLen > len ) || (dp[i] == sum && currentLen == len && currentLeft < bestLeft)) {
                sum = dp[i];
                len = currentLen;
                bestLeft = currentLeft;
            }
        }
        System.out.println(sum + " " + len + " " + bestLeft);




    }


}
