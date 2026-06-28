package dp;

import java.util.Scanner;

public class DemoBestTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().trim().split("\\s+");
        int length = inputs.length;
        int[] prices = new int[length];
        for (int i = 0; i < length; i++) {
            prices[i] = Integer.parseInt(inputs[i]);
        }
        int res = maxProfit(prices);
        System.out.println(res);
        scanner.close();
    }

    public static int maxProfit(int[] prices){
        if (prices.length <= 1) {
            return 0;
        }

        int low = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > low) {
                maxProfit = Math.max(maxProfit, prices[i] - low);
            } else {
                low = prices[i];
            }
        }
        return maxProfit;


    }
}