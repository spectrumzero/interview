package dp;

public class DemoStairsII {
    public static void main(String[] args) {

    }

    // 最小花费爬楼梯
    public static int solution(int[] costs) {
        int len = costs.length;
        int[] dp = new int[len + 1];
        // 你可以从第零阶开始，也可从第一阶开始
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            // costs 表示，从 i - 1 或 i - 2 向上爬的费用
            dp[i] = Math.min(dp[i - 1] + costs[i - 1], dp[i - 2] + costs[i - 2]);
        }
        return dp[len];
    }




}
