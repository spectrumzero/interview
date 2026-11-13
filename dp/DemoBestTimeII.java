package dp;

public class DemoBestTimeII {
    public static void main(String[] args) {

    }

    public static int solution(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            // 捕获所有上涨区间
            if (prices[i] > prices[i - 1]) {
                // 可以昨天买，今天卖。今天无法判断，也就是说不一定今天买。
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }


}
